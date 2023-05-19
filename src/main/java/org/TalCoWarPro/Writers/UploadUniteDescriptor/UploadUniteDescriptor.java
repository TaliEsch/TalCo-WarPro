package org.TalCoWarPro.Writers.UploadUniteDescriptor;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;

import java.io.*;
import java.util.ArrayList;

public class UploadUniteDescriptor {
    BufferedReader reader;
    BufferedWriter writer;
    String line;
    ArrayList<UniteDescriptor> uniteDescList;

    public UploadUniteDescriptor (ArrayList<UniteDescriptor> uniteDescList){
        this.uniteDescList = uniteDescList;
    }

    public void WriteToFile() throws IOException {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("UniteDescriptor.ndf")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\nSorry, the application cannot find UniteDescriptor.ndf Please ensure it is in the same director as this jar file");
        }
        try {
            File file = new File("Output");
            if (!file.exists()) {
                file.mkdirs();
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Output/UniteDescriptor.ndf")));
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("\nSorry the application is unable to write to Output/UniteDescriptor.ndf");
        }

        int count = 0;
        String booleanTemp;

        // Skip the first 3 lines (they're empty)
        line = reader.readLine();

        for (int i = 0; i < 2; i++){
            writer.write(line);
            writer.newLine();
            line = reader.readLine();
        }

        while ((line = reader.readLine())!= null) {
            // Start of export block
            if (line.startsWith("export")){
                stringWrite("Descriptor", 7, 1, "is TEntityDescriptor", uniteDescList.get(count).getDescriptor());
                stringWrite("Nationalite", 47, null, null, uniteDescList.get(count).getNationalite());
                stringWrite("MotherCountry", 48, null, "'",uniteDescList.get(count).getMotherCountry());
                stringWrite("AcknowUnitType", 47, null, null, uniteDescList.get(count).getAcknowUnitType());
                stringWrite("TypeUnitFormation", 48, null, "'", uniteDescList.get(count).getTypeUnitFormation());
                ArrayList<String> initialFlagSet = uniteDescList.get(count).getInitialFlagSet();
                if (initialFlagSet != null  && initialFlagSet.size() > 0) {
                    for (int i = 0; i < initialFlagSet.size(); i++) {
                        String temp = initialFlagSet.get(i).concat(",");
                        initialFlagSet.set(i, temp);
                    }
                }
                blockStringWrite("InitialFlagSet", 16, null, 12, uniteDescList.get(count).getInitialFlagSet());
                booleanTemp = String.valueOf(uniteDescList.get(count).getUseFollowCam());
                stringWrite("UseFollowCam", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getStickToGround());
                stringWrite("StickToGround", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getInGeoDb());
                stringWrite("InGeoDb", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getPorteurMustBeVisible());
                stringWrite("PorteurMustBeVisible", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getClampInWorld());
                stringWrite("ClampInWorld", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getClampOutMap());
                stringWrite("ClampOutMap", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("RelativeScanningPosition", 45, null, null, uniteDescList.get(count).getRelativeScanningPosition());
                stringWrite("LowAltitudeFlyingAltitude", 46, 1, null, uniteDescList.get(count).getLowAltitudeFlyingAltitude());
                stringWrite("NearGroundFlyingAltitude", 46, 1, null, uniteDescList.get(count).getNearGroundFlyingAltitude());
                ArrayList<String> ttagsModuleDescriptor = uniteDescList.get(count).getTTagsModuleDescriptor();
                if (ttagsModuleDescriptor != null  && ttagsModuleDescriptor.size() > 0) {
                    for (int i = 0; i < ttagsModuleDescriptor.size(); i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\"").append(ttagsModuleDescriptor.get(i)).append("\",");
                        String temp = sb.toString();
                        ttagsModuleDescriptor.set(i, temp);
                    }
                    blockStringWrite("TagSet", 16, 1, 12, uniteDescList.get(count).getTTagsModuleDescriptor());
                }
                stringWrite("ExperienceLevelsPackDescriptor", 45, null, null, uniteDescList.get(count).getExperienceLevelsPackDescriptor());
                booleanTemp = String.valueOf(uniteDescList.get(count).getCanWinExperience());
                stringWrite("CanWinExperience", 31, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("ExperienceGainBySecond", 37, null, null, uniteDescList.get(count).getExperienceGainBySecond());
                stringWrite("ExperienceMultiplierBonusOnKill", 46, null, null, uniteDescList.get(count).getExperienceMultiplierBonusOnKill());
                stringWrite("AutoRevealType", 35, null, null, uniteDescList.get(count).getAutoRevealType());
                stringWrite("UnitConcealmentBonus", 35, null, null, uniteDescList.get(count).getUnitConcealmentBonus());
                stringWrite("VisionUnitType", 35, null, null, uniteDescList.get(count).getVisionUnitType());
                booleanTemp = String.valueOf(uniteDescList.get(count).getUnitIsStealth());
                stringWrite("UnitIsStealth", 35, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getHideFromDebug());
                stringWrite("HideFromDebug", 35, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));

                // Handling for units with shorter versions of TApparenceModelModuleDescriptor
                int pointer = 39;
                boolean shortened = true;
                while (!(line.contains("TModuleSelector"))) {
                    while (!(line.startsWith(")"))) {
                        if (line.contains("Default")) {
                            pointer = 57;
                            shortened = false;
                            break;
                        } else if (line.contains("PickableObject")) {
                            break;
                        }
                        writer.newLine();
                        writer.write(line);
                        line = reader.readLine();
                    }
                    booleanTemp = String.valueOf(uniteDescList.get(count).getPickableObject());
                    stringWrite("PickableObject", pointer, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                    stringWrite("Depiction", pointer, null, null, uniteDescList.get(count).getDepiction());
                    if (!shortened) {
                        stringWrite("GhostDepiction", pointer, null, null, uniteDescList.get(count).getGhostDepiction());
                        StringBuilder sb = new StringBuilder();
                        sb.append("\"").append(uniteDescList.get(count).getBlackHoleIdentifier()).append("\"");
                        String temp = sb.toString();
                        stringWrite("BlackHoleIdentifier", pointer, null, null, temp);
                        sb = new StringBuilder();
                        sb.append("\"").append(uniteDescList.get(count).getGameplayBBoxBoneName()).append("\"");
                        temp = sb.toString();
                        stringWrite("GameplayBBoxBoneName", pointer, null, null, temp);
                        break;
                    } else{
                        writer.newLine();
                        writer.write(line);
                        line = reader.readLine();
                    }
                }

                // Cycle through unneccessary lines
                for (int i = 0; i < 4; i++){
                    writer.newLine();
                    writer.write(line);
                    line = reader.readLine();
                }

                stringWrite("AutoCoverRange", 49, null, null, uniteDescList.get(count).getAutoCoverRange());
                stringWrite("OccupationRadius", 49, null, null, uniteDescList.get(count).getOccupationRadius());
                stringWrite("TerrainListMask", 49, null, null, uniteDescList.get(count).getTerrainListMask());
                stringWrite("TerrainList                =", 49, null, null, uniteDescList.get(count).getTerrainList());
                booleanTemp = String.valueOf(uniteDescList.get(count).getUseTerrainsForEscape());
                stringWrite("UseTerrainsForEscape", 49, null, null,  booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("            Default        =", 29, null, null, uniteDescList.get(count).getWeaponManagerDefault());
                stringWrite("            Selection      =", 30, 1, null, uniteDescList.get(count).getWeaponManagerSelection());
                stringWrite("SuppressDamagesRegenRatio", 52, null, null, uniteDescList.get(count).getSuppressDamagesRegenRatio());
                stringWrite("SuppressDamagesRegenRatioOutOfRange", 62, null, null, uniteDescList.get(count).getSuppressDamagesRegenRatioOutOfRange());
                stringWrite("StunDamagesRegen", 43, null, null, uniteDescList.get(count).getStunDamagesRegen());
                booleanTemp = String.valueOf(uniteDescList.get(count).getStunFreezesUnits());
                stringWrite("StunFreezesUnits", 43, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("BlindageProperties", 45, null, null, uniteDescList.get(count).getBlindageProperties());
                stringWrite("ArmorDescriptorFront", 51, null, null, uniteDescList.get(count).getArmorDescriptorFront());
                stringWrite("ArmorDescriptorSides", 51, null, null, uniteDescList.get(count).getArmorDescriptorSides());
                stringWrite("ArmorDescriptorRear", 50, null, null, uniteDescList.get(count).getArmorDescriptorRear());
                stringWrite("ArmorDescriptorTop", 49, null, null, uniteDescList.get(count).getArmorDescriptorTop());
                stringWrite("MaxSuppressionDamages", 48, null, null, uniteDescList.get(count).getMaxSuppressionDamages());
                stringWrite("MaxStunDamages", 41, null, null, uniteDescList.get(count).getMaxStunDamages());
                stringWrite("MaxDamages", 33, null, null, uniteDescList.get(count).getMaxDamages());
                booleanTemp = String.valueOf(uniteDescList.get(count).getKillWhenDamagesReachMax());
                stringWrite("KillWhenDamagesReachMax", 46, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("HitRollSize", 34, null, null, uniteDescList.get(count).getHitRollSize());
                stringWrite("HitRollECM", 33, null, null, uniteDescList.get(count).getHitRollECM());
                booleanTemp = String.valueOf(uniteDescList.get(count).getAutoOrientation());
                stringWrite("AutoOrientation", 38, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getSkipCadavreCreation());
                stringWrite("SkipCadavreCreation", 43, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getUseTopArmorAgainstFire());
                stringWrite("UseTopArmorAgainstFire", 45, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("PhysicalDamageLevelsPack", 47, null, null, uniteDescList.get(count).getPhysicalDamageLevelsPack());
                stringWrite("SuppressDamageLevelsPack", 47, null, null, uniteDescList.get(count).getSuppressDamageLevelsPack());
                stringWrite("StunDamageLevelsPack", 43, null, null, uniteDescList.get(count).getStunDamageLevelsPack());
                stringWrite("                 Dangerousness  =", 34, null, null, uniteDescList.get(count).getDangerousness());
                stringWrite("MoralLevel", 21, null, null, uniteDescList.get(count).getMoralLevel());
                stringWrite("MaxSpeed", 34, null, null, uniteDescList.get(count).getMaxSpeed());
                stringWrite("UnitMovingType", 37, null, null, uniteDescList.get(count).getUnitMovingType());
                stringWrite("PathfindType", 35, null, null, uniteDescList.get(count).getPathfindType());
                stringWrite("PreferredLayerMask", 41, null, null, uniteDescList.get(count).getPreferredLayerMask());
                stringWrite("VitesseCombat", 37, 1, null, uniteDescList.get(count).getVitesseCombat());
                stringWrite("SpeedBonusOnRoad", 39, null, null, uniteDescList.get(count).getSpeedBonusOnRoad());
                stringWrite("MaxAcceleration", 39, 1, null, uniteDescList.get(count).getMaxAcceleration());
                stringWrite("MaxDeceleration", 39, 1, null, uniteDescList.get(count).getMaxDeceleration());
                stringWrite("TempsDemiTour", 36, null, null, uniteDescList.get(count).getTempsDemiTour());
                stringWrite("VehicleSubType", 37, null, null, uniteDescList.get(count).getVehicleSubType());
                stringWrite("StartTime", 33, 1, null, uniteDescList.get(count).getStartTime());
                stringWrite("StopTime", 32, 1, null, uniteDescList.get(count).getStopTime());
                stringWrite("RotationStartTime", 41, 1, null, uniteDescList.get(count).getRotationStartTime());
                stringWrite("RotationStopTime", 40, 1, null, uniteDescList.get(count).getRotationStopTime());
                stringWrite("FuelCapacity", 39, null, null, uniteDescList.get(count).getFuelCapacity());
                stringWrite("FuelMoveDuration", 39, null, null, uniteDescList.get(count).getFuelMoveDuration());
                stringWrite("OpticsAltitudeConfig", 43, null, null, uniteDescList.get(count).getOpticsAltitudeConfig());
                booleanTemp = String.valueOf(uniteDescList.get(count).getDoesNotCountInScannerAbsoluteMaxRange());
                stringWrite("DoesNotCountInScannerAbsoluteMaxRange", 60, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("PorteeVisionTBA", 39, 1, null, uniteDescList.get(count).getPorteeVisionTBA());
                stringWrite("PorteeVisionFOW", 39, 1, null, uniteDescList.get(count).getPorteeVisionFOW());
                stringWrite("DetectionTBA", 36, 1, null, uniteDescList.get(count).getDetectionTBA());
                stringWrite("PorteeVision", 36, 1, null, uniteDescList.get(count).getPorteeVision());

                stringWrite("PorteeIdentification", 43, null, null, uniteDescList.get(count).getPorteeIdentification());
                stringWrite("OpticalStrength", 38, null, null, uniteDescList.get(count).getOpticalStrength());
                stringWrite("OpticalStrengthAltitude", 46, null, null, uniteDescList.get(count).getOpticalStrengthAltitude());
                booleanTemp = String.valueOf(uniteDescList.get(count).getUnitDetectStealthUnit());
                stringWrite("UnitDetectStealthUnit", 44, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));


                // TODO: Convert to ArrayLists + add new tables
/*                stringWrite("SpecializedDetections", 26, 1, ")", uniteDescList.get(count).getSpecializedDetections());
                stringWrite("SpecializedOpticalStrengths", 26, 1, ")", uniteDescList.get(count).getSpecializedOpticalStrengths());*/
          /*      stringWrite("IgnoreObstacles", 26, 1, ")", uniteDescList.get(count).getIgnoreObstacles());*/

                stringWrite("IdentifyBaseProbability", 46, null, null, uniteDescList.get(count).getIdentifyBaseProbability());
                stringWrite("TimeBetweenEachIdentifyRoll", 46, null, null, uniteDescList.get(count).getTimeBetweenEachIdentifyRoll());
                stringWrite("VisibilityRuleDescriptor", 46, null, null, uniteDescList.get(count).getVisibilityRuleDescriptor());
                stringWrite("DistanceMultiplierRule", 46, null, null, uniteDescList.get(count).getDistanceMultiplierRule());
                stringWrite("MultiplicateurAPorteeMaximale", 63, null, null, uniteDescList.get(count).getMultiplicateurAPorteeMaximale());

                stringWrite("MultiplicateurAPorteeMinimale", 63, null, null, uniteDescList.get(count).getMultiplicateurAPorteeMinimale());
                stringWrite("Exposant", 63, null, null, uniteDescList.get(count).getExposant());
                stringWrite("MultiplicateurAPorteeMaximaleEnMouvement", 63, null, null, uniteDescList.get(count).getMultiplicateurAPorteeMaximaleEnMouvement());
                stringWrite("MultiplicateurAPorteeMinimaleEnMouvement", 63, null, null, uniteDescList.get(count).getMultiplicateurAPorteeMinimaleEnMouvement());
                stringWrite("ExposantEnMouvement", 63, null, null, uniteDescList.get(count).getExposantEnMouvement());

                // Skip "blank" lines
                for (int i = 0; i < 4; i++){
                    writer.newLine();
                    writer.write(line);
                    line = reader.readLine();
                }


                // stringWrite("Categories", 47, null, null, uniteDescList.get(count).getIsTransport());
                // TODO: Make this work, enabling transporting for units that don't have it and removing it from those that do

                stringWrite("TransportedTexture", 57, null, null, uniteDescList.get(count).getTransportedTexture());
                stringWrite("TransportedSoldier", 58, 1, null, uniteDescList.get(count).getTransportedSoldier());
                stringWrite("NbSeatsOccupied", 57, null, null, uniteDescList.get(count).getNbSeatsOccupied());
                stringWrite("TimeToLoad", 57, null, null, uniteDescList.get(count).getTimeToLoad());
                booleanTemp = String.valueOf(uniteDescList.get(count).getIsTowable());
                stringWrite("IsTowable", 57, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));

                ArrayList<String> transporterCategories = uniteDescList.get(count).getTransporterCategories();
                if (transporterCategories != null  && transporterCategories.size() > 0) {
                    int point = 0;
                    for (int i = 0; i < transporterCategories.size(); i++) {
                        StringBuilder sb = new StringBuilder();
                        if (point == 0){
                            sb.append("\"").append(transporterCategories.get(i)).append("\",");
                        }else {
                            sb.append("\"").append(transporterCategories.get(i)).append(",");
                        }
                        point ++;
                        String temp = sb.toString();
                        transporterCategories.set(i, temp);
                    }
                    blockStringWrite("Categories", 40, 2, 52, uniteDescList.get(count).getTransporterCategories());
                }
                ArrayList<String> transportableTagSet = uniteDescList.get(count).getTransportableTagSet();
                if (transportableTagSet != null  && transportableTagSet.size() > 0) {
                    int point = 0;
                    for (int i = 0; i < transportableTagSet.size(); i++) {
                        StringBuilder sb = new StringBuilder();
                        if (point == 0){
                            sb.append("\"").append(transportableTagSet.get(i)).append("\",");
                        }else {
                            sb.append("\"").append(transportableTagSet.get(i)).append(",");
                        }
                        point ++;
                        String temp = sb.toString();
                        transportableTagSet.set(i, temp);
                    }
                    blockStringWrite("TransportableTagSet", 40, 2, 52, uniteDescList.get(count).getTransportableTagSet());
                }
                stringWrite("NbSeatsAvailable", 52, null, null, uniteDescList.get(count).getNbSeatsAvailable());
                stringWrite("WreckUnloadPhysicalDamageBonus", 52, null, null, uniteDescList.get(count).getWreckUnloadPhysicalDamageBonus());
                stringWrite("WreckUnloadSuppressDamageBonus", 52, null, null, uniteDescList.get(count).getWreckUnloadSuppressDamageBonus());
                stringWrite("WreckUnloadStunDamageBonus", 52, null, null, uniteDescList.get(count).getWreckUnloadStunDamageBonus());
                stringWrite("LoadRadius", 53, 1, null, uniteDescList.get(count).getLoadRadius());
                stringWrite("Factory", 41, null, null, uniteDescList.get(count).getFactory());
                stringWrite("ProductionTime", 41, null, null, uniteDescList.get(count).getProductionTime());
                stringWrite("CommandPoints", 51, 2, null, uniteDescList.get(count).getCommandPoints());
                stringWrite("Resource_Tickets", 45, 2, null, uniteDescList.get(count).getResourceTickets());
                booleanTemp = String.valueOf(uniteDescList.get(count).getCanAssist());
                stringWrite("CanAssist", 33, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("AssistRequestBroadcastRadius", 52, null, null, uniteDescList.get(count).getAssistRequestBroadcastRadius());
                stringWrite("DistanceToFlee", 38, null, null, uniteDescList.get(count).getDistanceToFlee());
                stringWrite("MaxDistanceForOffensiveReaction", 55, null, null, uniteDescList.get(count).getMaxDistanceForOffensiveReaction());
                stringWrite("MaxDistanceForOffensiveReactionOnFlyingTarget", 69, null, null, uniteDescList.get(count).getMaxDistanceForOffensiveReactionOnFlyingTarget());
                stringWrite("MaxDistanceForEngagement", 48, null, null, uniteDescList.get(count).getMaxDistanceForEngagement());

                ArrayList<String> searchedTagsInEngagementTarget = uniteDescList.get(count).getSearchedTagsInEngagementTarget();
                if(searchedTagsInEngagementTarget != null  && searchedTagsInEngagementTarget.size() > 0) {
                    for (int i = 0; i < searchedTagsInEngagementTarget.size(); i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\"").append(searchedTagsInEngagementTarget.get(i)).append("\",");
                        String temp = sb.toString();
                        searchedTagsInEngagementTarget.set(i, temp);
                    }
                    blockStringWrite("SearchedTagsInEngagementTarget", 24, 2, 21, uniteDescList.get(count).getSearchedTagsInEngagementTarget());
                }

                stringWrite("Texture", 27, 1, null, uniteDescList.get(count).getMinimapDisplayTexture());
                stringWrite("GhostTexture", 32, 1, null, uniteDescList.get(count).getMinimapDisplayGhostTexture());
                booleanTemp = String.valueOf(uniteDescList.get(count).getMinimapDisplayIsAlwaysVisible());
                stringWrite("IsAlwaysVisible", 34, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(uniteDescList.get(count).getMinimapDisplayUseTeamColor());
                stringWrite("UseTeamColor", 31, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                booleanTemp = String.valueOf(String.valueOf(uniteDescList.get(count).getMinimapDisplayFollowUnitOrientation()));
                stringWrite("FollowUnitOrientation", 40, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("ValidOrders", 30, null, null, uniteDescList.get(count).getValidOrders());
                // TOrderConfigModuleDescriptor
                stringWrite("UnlockableOrders", 31, null, null, uniteDescList.get(count).getUnlockableOrders());
                // TTacticalLabelModuleDescriptor
                stringWrite("MultiSelectionSortingOrder", 45, null, null, uniteDescList.get(count).getMultiSelectionSortingOrder());
                stringWrite("UnitName", 46, 1, null, uniteDescList.get(count).getUnitName());
                stringWrite("IdentifiedTexture", 36, null, null, uniteDescList.get(count).getIdentifiedTexture());
                stringWrite("CommandNameTrigger", 41, null, null, uniteDescList.get(count).getIdentifiedTextureCommandNameTrigger());
                stringWrite("Alterator", 32, null, null, uniteDescList.get(count).getIdentifiedTextureAlterator());

                ArrayList<String> identifiedTextureValues = uniteDescList.get(count).getIdentifiedTextureValues();
                if (identifiedTextureValues != null  && identifiedTextureValues.size() > 0) {
                    int identifiedValInt = identifiedTextureValues.size() - 1;
                    for (int i = 0; i < identifiedValInt; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\"").append(identifiedTextureValues.get(i)).append("\",");
                        String temp = sb.toString();
                        identifiedTextureValues.set(i, temp);
                    }
                    StringBuilder sbTmp = new StringBuilder();
                    sbTmp.append("\"").append(identifiedTextureValues.get(identifiedValInt)).append("\"");
                    String tempStr = sbTmp.toString();
                    identifiedTextureValues.set(identifiedValInt, tempStr);
                    blockStringWrite("Values", 24, 2, 20, uniteDescList.get(count).getIdentifiedTextureValues());
                }
                stringWrite("DefaultSpecialtyToken", 46, 1, null, uniteDescList.get(count).getDefaultSpeciailtyToken());
                stringWrite("UnidentifiedTexture", 38, null, null, uniteDescList.get(count).getUnidentifiedTexture());
                stringWrite("CommandNameTrigger", 41, null, null, uniteDescList.get(count).getUnidentifiedTextureCommandNameTrigger());
                stringWrite("Alterator", 32, null, null, uniteDescList.get(count).getUnidentifiedTextureAlterator());

                ArrayList<String> unidentifiedTextureTextureValues = uniteDescList.get(count).getUnidentifiedTextureTextureValues();
                if (unidentifiedTextureTextureValues != null  && unidentifiedTextureTextureValues.size() > 0) {
                    int unidentifiedValInt = unidentifiedTextureTextureValues.size() - 1;
                    for (int i = 0; i < unidentifiedValInt; i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\"").append(unidentifiedTextureTextureValues.get(i)).append("\",");
                        String temp = sb.toString();
                        unidentifiedTextureTextureValues.set(i, temp);
                    }
                    StringBuilder sbTmp = new StringBuilder();
                    sbTmp.append("\"").append(unidentifiedTextureTextureValues.get(unidentifiedValInt)).append("\"");
                    String tempStr = sbTmp.toString();
                    unidentifiedTextureTextureValues.set(unidentifiedValInt, tempStr);
                    blockStringWrite("Values", 24, 2, 20, uniteDescList.get(count).getUnidentifiedTextureTextureValues());
                }
                stringWrite("PositionHeightOffset", 39, null, null, uniteDescList.get(count).getPositionHeightOffset());
                stringWrite("NbSoldiers", 45, null, null, uniteDescList.get(count).getNbSoldiers());
                // TAirplaneModuleDescriptor
                stringWrite("EvacuationTime", 33, null, null, uniteDescList.get(count).getEvacuationTime());
                stringWrite("TravelDuration", 33, null, null, uniteDescList.get(count).getTravelDuration());
                // TStrategicDataModuleDescriptor
                stringWrite("UnitAttackValue", 38, null, null, uniteDescList.get(count).getUnitAttackValue());
                stringWrite("UnitDefenseValue", 39, null, null, uniteDescList.get(count).getUnitDefenseValue());
                stringWrite("UnitBonusXpPerLevelValue", 47, null, null, uniteDescList.get(count).getUnitBonusXpPerLevelValue());
                // TUnitUIModuleDescriptor
                stringWrite("UnitRole", 28, 1, null, uniteDescList.get(count).getUnitRole());

                ArrayList<String> specialtiesList = uniteDescList.get(count).getSpecialtiesList();
                if (specialtiesList != null && specialtiesList.size() > 0) {
                    int specialtiesListInt = specialtiesList.size();
                    int point = 0;
                    for (int i = 0; i < specialtiesListInt; i++) {
                        StringBuilder sb = new StringBuilder(); // Not sure why but this was adding an extra ' if not done like this
                        if (point == 0){
                            sb.append("'").append(specialtiesList.get(i)).append("',");
                        }else {
                            sb.append("'").append(specialtiesList.get(i)).append(",");
                        }
                        point ++;
                        String temp = sb.toString();
                        specialtiesList.set(i, temp);
                    }
                    blockStringWrite("SpecialtiesList", 20, 1, 16, uniteDescList.get(count).getSpecialtiesList());
                }
                stringWrite("NameToken", 29, 1, null, uniteDescList.get(count).getNameToken());
                stringWrite("InfoPanelConfigurationToken", 47, null, null, uniteDescList.get(count).getInfoPanelConfigurationToken());
                stringWrite("TypeSpecificToken", 37, 1, null, uniteDescList.get(count).getTypeSpecificToken());
                stringWrite("RealRoadSpeed", 32, null, null, uniteDescList.get(count).getRealRoadSpeed());
                booleanTemp = String.valueOf(uniteDescList.get(count).getIsAce());
                stringWrite("IsAce", 24, null, null, booleanTemp.substring(0, 1).toUpperCase() + booleanTemp.substring(1));
                stringWrite("UpgradeFromUnit", 38, null, null, uniteDescList.get(count).getUpgradeFromUnit());
                stringWrite("GenerateName", 31, null, null, String.valueOf(uniteDescList.get(count).getGenerateName()));
                stringWrite("MenuIconTexture", 35, 1, null, uniteDescList.get(count).getMenuIconTexture());
                stringWrite("ButtonTexture", 33, 1, null, uniteDescList.get(count).getButtonTexture());
                stringWrite("CountryTexture", 34, 1, null, uniteDescList.get(count).getCountryTexture());
                stringWrite("TypeStrategicCount", 37, null, null, uniteDescList.get(count).getTypeStrategicCount());

                count ++;

                writer.newLine();
                writer.write(line);

            }else{
                writer.newLine();
                writer.write(line);
            }
        }
        reader.close();
        writer.close();
        System.out.println("Written successfully");
    }

    private void stringWrite(String str, Integer index1, Integer index2, String strIndex, String strToInsert) throws IOException {
        String result;
        if (strToInsert != null && !strToInsert.equals("Null") && !strToInsert.equals("")) {
            while (!(line.startsWith(")"))) {
                if (line.contains(str)) {
                    if (strIndex != null && index2 != null){
                        // TODO: Remove this.. It's a dumb workaround
                        if (str.equals("SpecializedDetections")){
                            writer.newLine();
                            writer.write(line);
                            line = reader.readLine();
                        }
                        result = line.substring(0, index1) + strToInsert + line.substring(line.lastIndexOf(strIndex) - index2);
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    } else if (index2 != null) {
                        result = line.substring(0, index1) + strToInsert + line.substring(line.length() - index2);
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    } else if (strIndex != null) {
                        result = line.substring(0, index1) + strToInsert + line.substring(line.lastIndexOf(strIndex));
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    } else {
                        result = line.substring(0, index1) + strToInsert;
                        writer.newLine();
                        writer.write(result);
                        line = reader.readLine();
                    }
                    break;
                } else {
                    writer.newLine();
                     writer.write(line);
                    line = reader.readLine();
                }
            }
        }
    }

    private void blockStringWrite(String str, Integer index1, Integer index2, Integer index3, ArrayList<String> arrayToInsert) throws IOException {
        if (arrayToInsert != null) {
            while (!(line.startsWith(")"))) {
                if (line.contains(str)) {
                    if (line.endsWith("]")) {
                        String output = line.substring(line.lastIndexOf("["));
                        writer.newLine();
                        writer.write(output);
                    }else{
                        writer.newLine();
                        writer.write(line);
                        if ((line = reader.readLine()).contains("[")) {
                            writer.newLine();
                            writer.write(line);
                        }
                    }
                    for (String s : arrayToInsert) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(" ".repeat(Math.max(0, index1)));
                        sb.append(s);
                        String output = sb.toString();
                        writer.newLine();
                        writer.write(output);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(" ".repeat(Math.max(0, index3)));
                    sb.append("]");
                    String output = sb.toString();
                    writer.newLine();
                    writer.write(output);
                    while (!(line.contains("]"))) {
                        line = reader.readLine();
                    }
                    line = reader.readLine();
                    break;
                } else {
                    writer.newLine();
                    writer.write(line);
                    line = reader.readLine();
                }
            }
        }
    }
}





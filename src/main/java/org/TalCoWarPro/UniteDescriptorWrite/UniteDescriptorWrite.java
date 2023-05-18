package org.TalCoWarPro.UniteDescriptorWrite;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;

public class UniteDescriptorWrite {


    // Connection parameters
    String url = "jdbc:mariadb://localhost:3306/WarPro";
    String username;
    String password;

    public UniteDescriptorWrite(String username, String password){
        this.username = username;
        this.password = password;
    }


    // Connect to database
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void insertUniteDescriptor (ArrayList<UniteDescriptor> uniteDescriptorList) {
        // Clear the db

        try {
            ScriptRunner sr = new ScriptRunner(connect());
            Reader reader = new BufferedReader(new FileReader("src\\main\\java\\org\\TalCoWarPro\\schema.sql"));
            sr.runScript(reader);
            System.out.println("\nRE-CREATED WARPRO DATABASE");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        // SQL statements
        String insertUnitQuery = "INSERT INTO uniteDescriptor (descriptor, nationalite, motherCountry, acknowUnitType, " +
                "typeUnitFormation, useFollowCam, stickToGround, inGeoDb, porteurMustBeVisible, clampInWorld, " +
                "clampOutMap, relativeScanningPosition, lowAltitudeFlyingAltitude, nearGroundFlyingAltitude, " +
                "experienceLevelsPackDescriptor, canWinExperience, experienceGainBySecond, " +
                "experienceMultiplierBonusOnKill, autoRevealType, unitConcealmentBonus, visionUnitType, " +
                "unitIsStealth, hideFromDebug, pickableObject, depiction, ghostDepiction, blackHoleIdentifier, " +
                "gameplayBBoxBoneName, autoCoverRange, occupationRadius, terrainListMask, terrainList, " +
                "useTerrainsForEscape, weaponManagerDefault, weaponManagerSelection, suppressDamagesRegenRatio, " +
                "suppressDamagesRegenRatioOutOfRange, stunDamagesRegen, stunFreezesUnits, blindageProperties, " +
                "armorDescriptorFront, armorDescriptorSides, armorDescriptorRear, armorDescriptorTop, " +
                "maxSuppressionDamages, maxStunDamages, maxDamages, killWhenDamagesReachMax, hitRollSize, " +
                "hitRollECM, autoOrientation, skipCadavreCreation, useTopArmorAgainstFire, " +
                "physicalDamageLevelsPack, suppressDamageLevelsPack, stunDamageLevelsPack, dangerousness, moralLevel, " +
                "maxSpeed, unitMovingType, pathfindType, preferredLayerMask, vitesseCombat, speedBonusOnRoad, " +
                "maxAcceleration, maxDeceleration, tempsDemiTour, vehicleSubType, startTime, stopTime, " +
                "rotationStartTime, rotationStopTime, fuelCapacity, fuelMoveDuration, opticsAltitudeConfig, " +
                "doesNotCountInScannerAbsoluteMaxRange, porteeVisionTBA, porteeVisionFOW, detectionTBA, " +
                "porteeVision, porteeIdentification, opticalStrength, opticalStrengthAltitude, " +
                "unitDetectStealthUnit, specializedDetections, specializedOpticalStrengths, ignoreObstacles, " +
                "identifyBaseProbability, timeBetweenEachIdentifyRoll, visibilityRuleDescriptor, " +
                "distanceMultiplierRule, multiplicateurAPorteeMaximale, multiplicateurAPorteeMinimale, " +
                "exposant, multiplicateurAPorteeMaximaleEnMouvement, multiplicateurAPorteeMinimaleEnMouvement, " +
                "exposantEnMouvement, isTransport, transportedTexture, transportedSoldier, timeToLoad, nbSeatsOccupied, " +
                "isTowable, nbSeatsAvailable, wreckUnloadPhysicalDamageBonus, wreckUnloadSuppressDamageBonus, " +
                "wreckUnloadStunDamageBonus, loadRadius, factory, productionTime, commandPoints, resourceTickets, canAssist, " +
                "assistRequestBroadcastRadius, distanceToFlee, maxDistanceForOffensiveReaction, " +
                "maxDistanceForOffensiveReactionOnFlyingTarget, maxDistanceForEngagement, minimapDisplayTexture, "+
                "minimapDisplayGhostTexture, minimapDisplayIsAlwaysVisible, minimapDisplayUseTeamColor, minimapDisplayFollowUnitOrientation, validOrders, " +
                "unlockableOrders, multiSelectionSortingOrder, unitName, identifiedTexture, " +
                "identifiedTextureCommandNameTrigger, identifiedTextureAlterator, " +
                "defaultSpeciailtyToken, unidentifiedTexture, unidentifiedTextureCommandNameTrigger, " +
                "unidentifiedTextureAlterator, positionHeightOffset, nbSoldiers, " +
                "evacuationTime, travelDuration, unitAttackValue, unitDefenseValue, unitBonusXpPerLevelValue, " +
                "unitRole, nameToken, infoPanelConfigurationToken, typeSpecificToken, " +
                "realRoadSpeed, isAce, upgradeFromUnit, generateName, menuIconTexture, buttonTexture, " +
                "countryTexture, typeStrategicCount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "+
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "+
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "+
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "+
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String insertUnitInitalFlagset = "INSERT INTO unit_initial_flagset (unit_id, flag_value) VALUES (?, ?)";

        String insertUnitTTagsModuleDescriptor = "INSERT INTO unit_ttags_module_descriptor (unit_id, ttag_module_descriptor_value) VALUES (?, ?)";

        String insertUnitSearchedTagsInEngagementRange = "INSERT INTO unit_searched_tags_in_engagement_target (unit_id, searched_tag_value) VALUES (?, ?)";

        String insertUnitIdentifiedTextureValues = "INSERT INTO unit_identified_texture_values (unit_id, identified_texture_value) VALUES (?, ?)";

        String insertUnitUnidentifiedTextureValues = "INSERT INTO unit_unidentified_texture_texture_values (unit_id, unidentified_texture_texture_value) VALUES (?, ?)";

        String insertUnitSpecialtiesList = "INSERT INTO unit_specialties_list (unit_id, specialty_value) VALUES (?, ?)";

        String insertTransporterCategories = "INSERT INTO unit_transporter_categories (unit_id, transporter_categories_value) VALUES (?, ?)";

        String insertTransportableTagset= "INSERT INTO unit_transportable_tag_set (unit_id, transportable_tag_set_value) VALUES (?, ?)";


        try (
                Connection conn = connect();
        ){
            try (PreparedStatement ps = conn.prepareStatement(insertUnitQuery)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    ps.setString(1, uniteDescriptor.getDescriptor());
                    ps.setString(2, uniteDescriptor.getNationalite());
                    ps.setString(3, uniteDescriptor.getMotherCountry());
                    ps.setString(4, uniteDescriptor.getAcknowUnitType());
                    ps.setString(5, uniteDescriptor.getTypeUnitFormation());
                    ps.setObject(6, uniteDescriptor.getUseFollowCam());
                    ps.setObject(7, uniteDescriptor.getStickToGround());
                    ps.setObject(8, uniteDescriptor.getInGeoDb());
                    ps.setObject(9, uniteDescriptor.getPorteurMustBeVisible());
                    ps.setObject(10, uniteDescriptor.getClampInWorld());
                    ps.setObject(11, uniteDescriptor.getClampOutMap());
                    ps.setString(12, uniteDescriptor.getRelativeScanningPosition());
                    ps.setString(13, uniteDescriptor.getLowAltitudeFlyingAltitude());
                    ps.setString(14, uniteDescriptor.getNearGroundFlyingAltitude());
                    ps.setString(15, uniteDescriptor.getExperienceLevelsPackDescriptor());
                    ps.setObject(16, uniteDescriptor.getCanWinExperience());
                    ps.setString(17, uniteDescriptor.getExperienceGainBySecond());
                    ps.setString(18, uniteDescriptor.getExperienceMultiplierBonusOnKill());
                    ps.setString(19, uniteDescriptor.getAutoRevealType());
                    ps.setString(20, uniteDescriptor.getUnitConcealmentBonus());
                    ps.setString(21, uniteDescriptor.getVisionUnitType());
                    ps.setObject(22, uniteDescriptor.getUnitIsStealth());
                    ps.setObject(23, uniteDescriptor.getHideFromDebug());
                    ps.setObject(24, uniteDescriptor.getPickableObject());
                    ps.setString(25, uniteDescriptor.getDepiction());
                    ps.setString(26, uniteDescriptor.getGhostDepiction());
                    ps.setString(27, uniteDescriptor.getBlackHoleIdentifier());
                    ps.setString(28, uniteDescriptor.getGameplayBBoxBoneName());
                    ps.setString(29, uniteDescriptor.getAutoCoverRange());
                    ps.setString(30, uniteDescriptor.getOccupationRadius());
                    ps.setString(31, uniteDescriptor.getTerrainListMask());
                    ps.setString(32, uniteDescriptor.getTerrainList());
                    ps.setObject(33, uniteDescriptor.getUseTerrainsForEscape());
                    ps.setString(34, uniteDescriptor.getWeaponManagerDefault());
                    ps.setString(35, uniteDescriptor.getWeaponManagerSelection());
                    ps.setString(36, uniteDescriptor.getSuppressDamagesRegenRatio());
                    ps.setString(37, uniteDescriptor.getSuppressDamagesRegenRatioOutOfRange());
                    ps.setString(38, uniteDescriptor.getStunDamagesRegen());
                    ps.setObject(39, uniteDescriptor.getStunFreezesUnits());
                    ps.setString(40, uniteDescriptor.getBlindageProperties());
                    ps.setString(41, uniteDescriptor.getArmorDescriptorFront());
                    ps.setString(42, uniteDescriptor.getArmorDescriptorSides());
                    ps.setString(43, uniteDescriptor.getArmorDescriptorRear());
                    ps.setString(44, uniteDescriptor.getArmorDescriptorTop());
                    ps.setString(45, uniteDescriptor.getMaxSuppressionDamages());
                    ps.setString(46, uniteDescriptor.getMaxStunDamages());
                    ps.setString(47, uniteDescriptor.getMaxDamages());
                    ps.setObject(48, uniteDescriptor.getKillWhenDamagesReachMax());
                    ps.setString(49, uniteDescriptor.getHitRollSize());
                    ps.setString(50, uniteDescriptor.getHitRollECM());
                    ps.setObject(51, uniteDescriptor.getAutoOrientation());
                    ps.setObject(52, uniteDescriptor.getSkipCadavreCreation());
                    ps.setObject(53, uniteDescriptor.getUseTopArmorAgainstFire());
                    ps.setString(54, uniteDescriptor.getPhysicalDamageLevelsPack());
                    ps.setString(55, uniteDescriptor.getSuppressDamageLevelsPack());
                    ps.setString(56, uniteDescriptor.getStunDamageLevelsPack());
                    ps.setString(57, uniteDescriptor.getDangerousness());
                    ps.setString(58, uniteDescriptor.getMoralLevel());
                    ps.setString(59, uniteDescriptor.getMaxSpeed());
                    ps.setString(60, uniteDescriptor.getUnitMovingType());
                    ps.setString(61, uniteDescriptor.getPathfindType());
                    ps.setString(62, uniteDescriptor.getPreferredLayerMask());
                    ps.setString(63, uniteDescriptor.getVitesseCombat());
                    ps.setString(64, uniteDescriptor.getSpeedBonusOnRoad());
                    ps.setString(65, uniteDescriptor.getMaxAcceleration());
                    ps.setString(66, uniteDescriptor.getMaxDeceleration());
                    ps.setString(67, uniteDescriptor.getTempsDemiTour());
                    ps.setString(68, uniteDescriptor.getVehicleSubType());
                    ps.setString(69, uniteDescriptor.getStartTime());
                    ps.setString(70, uniteDescriptor.getStopTime());
                    ps.setString(71, uniteDescriptor.getRotationStartTime());
                    ps.setString(72, uniteDescriptor.getRotationStopTime());
                    ps.setString(73, uniteDescriptor.getFuelCapacity());
                    ps.setString(74, uniteDescriptor.getFuelMoveDuration());
                    ps.setString(75, uniteDescriptor.getOpticsAltitudeConfig());
                    ps.setObject(76, uniteDescriptor.getDoesNotCountInScannerAbsoluteMaxRange());
                    ps.setString(77, uniteDescriptor.getPorteeVisionTBA());
                    ps.setString(78, uniteDescriptor.getPorteeVisionFOW());
                    ps.setString(79, uniteDescriptor.getDetectionTBA());
                    ps.setString(80, uniteDescriptor.getPorteeVision());
                    ps.setString(81, uniteDescriptor.getPorteeIdentification());
                    ps.setString(82, uniteDescriptor.getOpticalStrength());
                    ps.setString(83, uniteDescriptor.getOpticalStrengthAltitude());
                    ps.setObject(84, uniteDescriptor.getUnitDetectStealthUnit());
                    ps.setString(85, uniteDescriptor.getSpecializedDetections());
                    ps.setString(86, uniteDescriptor.getSpecializedOpticalStrengths());
                    ps.setString(87, uniteDescriptor.getIgnoreObstacles());
                    ps.setString(88, uniteDescriptor.getIdentifyBaseProbability());
                    ps.setString(89, uniteDescriptor.getTimeBetweenEachIdentifyRoll());
                    ps.setString(90, uniteDescriptor.getVisibilityRuleDescriptor());
                    ps.setString(91, uniteDescriptor.getDistanceMultiplierRule());
                    ps.setString(92, uniteDescriptor.getMultiplicateurAPorteeMaximale());
                    ps.setString(93, uniteDescriptor.getMultiplicateurAPorteeMinimale());
                    ps.setString(94, uniteDescriptor.getExposant());
                    ps.setString(95, uniteDescriptor.getMultiplicateurAPorteeMaximaleEnMouvement());
                    ps.setString(96, uniteDescriptor.getMultiplicateurAPorteeMinimaleEnMouvement());
                    ps.setString(97, uniteDescriptor.getExposantEnMouvement());
                    ps.setObject(98, uniteDescriptor.getIsTransport());
                    ps.setString(99, uniteDescriptor.getTransportedTexture());
                    ps.setString(100, uniteDescriptor.getTransportedSoldier());
                    ps.setString(101, uniteDescriptor.getTimeToLoad());
                    ps.setString(102, uniteDescriptor.getNbSeatsOccupied());
                    ps.setObject(103, uniteDescriptor.getIsTowable());
                    ps.setObject(104, uniteDescriptor.getNbSeatsAvailable());
                    ps.setObject(105, uniteDescriptor.getWreckUnloadPhysicalDamageBonus());
                    ps.setObject(106, uniteDescriptor.getWreckUnloadSuppressDamageBonus());
                    ps.setObject(107, uniteDescriptor.getWreckUnloadStunDamageBonus());
                    ps.setObject(108, uniteDescriptor.getLoadRadius());
                    ps.setString(109, uniteDescriptor.getFactory());
                    ps.setString(110, uniteDescriptor.getProductionTime());
                    ps.setString(111, uniteDescriptor.getCommandPoints());
                    ps.setString(112, uniteDescriptor.getResourceTickets());
                    ps.setObject(113, uniteDescriptor.getCanAssist());
                    ps.setString(114, uniteDescriptor.getAssistRequestBroadcastRadius());
                    ps.setString(115, uniteDescriptor.getDistanceToFlee());
                    ps.setString(116, uniteDescriptor.getMaxDistanceForOffensiveReaction());
                    ps.setString(117, uniteDescriptor.getMaxDistanceForOffensiveReactionOnFlyingTarget());
                    ps.setString(118, uniteDescriptor.getMaxDistanceForEngagement());
                    ps.setString(119, uniteDescriptor.getMinimapDisplayTexture());
                    ps.setString(120, uniteDescriptor.getMinimapDisplayGhostTexture());
                    ps.setObject(121, uniteDescriptor.getMinimapDisplayIsAlwaysVisible());
                    ps.setObject(122, uniteDescriptor.getMinimapDisplayUseTeamColor());
                    ps.setObject(123, uniteDescriptor.getMinimapDisplayFollowUnitOrientation());
                    ps.setString(124, uniteDescriptor.getValidOrders());
                    ps.setString(125, uniteDescriptor.getUnlockableOrders());
                    ps.setString(126, uniteDescriptor.getMultiSelectionSortingOrder());
                    ps.setString(127, uniteDescriptor.getUnitName());
                    ps.setString(128, uniteDescriptor.getIdentifiedTexture());
                    ps.setString(129, uniteDescriptor.getIdentifiedTextureCommandNameTrigger());
                    ps.setString(130, uniteDescriptor.getIdentifiedTextureAlterator());
                    ps.setString(131, uniteDescriptor.getDefaultSpeciailtyToken());
                    ps.setString(132, uniteDescriptor.getUnidentifiedTexture());
                    ps.setString(133, uniteDescriptor.getUnidentifiedTextureCommandNameTrigger());
                    ps.setString(134, uniteDescriptor.getUnidentifiedTextureAlterator());
                    ps.setString(135, uniteDescriptor.getPositionHeightOffset());
                    ps.setString(136, uniteDescriptor.getNbSoldiers());
                    ps.setString(137, uniteDescriptor.getEvacuationTime());
                    ps.setString(138, uniteDescriptor.getTravelDuration());
                    ps.setString(139, uniteDescriptor.getUnitAttackValue());
                    ps.setString(140, uniteDescriptor.getUnitDefenseValue());
                    ps.setString(141, uniteDescriptor.getUnitBonusXpPerLevelValue());
                    ps.setString(142, uniteDescriptor.getUnitRole());
                    ps.setString(143, uniteDescriptor.getNameToken());
                    ps.setString(144, uniteDescriptor.getInfoPanelConfigurationToken());
                    ps.setString(145, uniteDescriptor.getTypeSpecificToken());
                    ps.setString(146, uniteDescriptor.getRealRoadSpeed());
                    ps.setObject(147, uniteDescriptor.getIsAce());
                    ps.setString(148, uniteDescriptor.getUpgradeFromUnit());
                    ps.setObject(149, uniteDescriptor.getGenerateName());
                    ps.setString(150, uniteDescriptor.getMenuIconTexture());
                    ps.setString(151, uniteDescriptor.getButtonTexture());
                    ps.setString(152, uniteDescriptor.getCountryTexture());
                    ps.setString(153, uniteDescriptor.getTypeStrategicCount());
                    ps.addBatch();
                    ps.executeBatch();
                }
            } catch (SQLException e) {
                    System.out.println(e.getMessage());
            }
            String test;
            try(PreparedStatement prep2 = conn.prepareStatement(insertUnitInitalFlagset)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String flag : uniteDescriptor.getInitialFlagSet()) {
                        prep2.setInt(1, uniteDescriptor.getReferenceId());
                        prep2.setString(2, flag);
                        prep2.addBatch();
                    }
                    prep2.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep3 = conn.prepareStatement(insertUnitTTagsModuleDescriptor)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String module : uniteDescriptor.getTTagsModuleDescriptor()) {
                        prep3.setInt(1, uniteDescriptor.getReferenceId());
                        prep3.setString(2, module);
                        prep3.addBatch();
                    }
                    prep3.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep4 = conn.prepareStatement(insertUnitSearchedTagsInEngagementRange)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String searchedTag : uniteDescriptor.getSearchedTagsInEngagementTarget()) {
                        prep4.setInt(1, uniteDescriptor.getReferenceId());
                        prep4.setString(2, searchedTag);
                        prep4.addBatch();
                    }
                    prep4.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep5 = conn.prepareStatement(insertUnitIdentifiedTextureValues)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String textureValue : uniteDescriptor.getIdentifiedTextureValues()) {
                        prep5.setInt(1, uniteDescriptor.getReferenceId());
                        prep5.setString(2, textureValue);
                        prep5.addBatch();
                    }
                    prep5.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep6 = conn.prepareStatement(insertUnitUnidentifiedTextureValues)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String textureValue : uniteDescriptor.getUnidentifiedTextureTextureValues()) {
                        prep6.setInt(1, uniteDescriptor.getReferenceId());
                        prep6.setString(2, textureValue);
                        prep6.addBatch();
                    }
                    prep6.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep7 = conn.prepareStatement(insertUnitSpecialtiesList)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String specialty : uniteDescriptor.getSpecialtiesList()) {
                        prep7.setInt(1, uniteDescriptor.getReferenceId());
                        prep7.setString(2, specialty);
                        prep7.addBatch();
                    }
                    prep7.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep8 = conn.prepareStatement(insertTransporterCategories)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String specialty : uniteDescriptor.getTransporterCategories()) {
                        prep8.setInt(1, uniteDescriptor.getReferenceId());
                        prep8.setString(2, specialty);
                        prep8.addBatch();
                    }
                    prep8.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            try(PreparedStatement prep9 = conn.prepareStatement(insertTransportableTagset)){
                for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
                    for (String specialty : uniteDescriptor.getTransportableTagSet()) {
                        prep9.setInt(1, uniteDescriptor.getReferenceId());
                        prep9.setString(2, specialty);
                        prep9.addBatch();
                    }
                    prep9.executeBatch();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
    }

}





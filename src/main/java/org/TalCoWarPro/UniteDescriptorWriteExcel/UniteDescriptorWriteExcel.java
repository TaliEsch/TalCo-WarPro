package org.TalCoWarPro.UniteDescriptorWriteExcel;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class UniteDescriptorWriteExcel {


    String excelFilePath = "Output\\UniteDescriptorExcel.xlsx";
    ArrayList<UniteDescriptor> uniteDescriptorList;

    public void insertUniteDescriptor (ArrayList<UniteDescriptor> uniteDescriptorList) {
        this.uniteDescriptorList = uniteDescriptorList;

        //Excel

        try{
            File yourFile = new File("Output\\");
            if (!yourFile.exists()) {
                yourFile.mkdirs();
            }
            try{
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
                XSSFSheet xssfSheet = xssfWorkbook.createSheet("Unite Descriptor");
                writeHeaderLine(xssfSheet);
                XSSFSheet unitInitalFlagsetSheet = xssfWorkbook.createSheet("Inital Flagset");
                writeHeaderLinkedTable(unitInitalFlagsetSheet, "Flag_Value");
                XSSFSheet unitTTagsModuleDescriptorSheet = xssfWorkbook.createSheet("Ttags Module Descriptor");
                writeHeaderLinkedTable(unitTTagsModuleDescriptorSheet, "TTag_Module");
                XSSFSheet unitSearchedTagsInEngagementRange = xssfWorkbook.createSheet("Tags In Engagement Range");
                writeHeaderLinkedTable(unitSearchedTagsInEngagementRange, "Tag_In_Engagement_Range");
                XSSFSheet unitIdentifiedTextureValues = xssfWorkbook.createSheet("Identified Texture Values");
                writeHeaderLinkedTable(unitIdentifiedTextureValues, "Value");
                XSSFSheet unitUnidentifiedTextureValues = xssfWorkbook.createSheet("Unidentified Texture Values");
                writeHeaderLinkedTable(unitUnidentifiedTextureValues, "Value");
                XSSFSheet unitSpecialtiesList = xssfWorkbook.createSheet("Specialties List");
                writeHeaderLinkedTable(unitSpecialtiesList, "Specialty_List");
                XSSFSheet transporterCategories = xssfWorkbook.createSheet("Transporter Categories");
                writeHeaderLinkedTable(unitSpecialtiesList, "Transport_Category");
                XSSFSheet transportableTagset = xssfWorkbook.createSheet("Transportable Tagset");
                writeHeaderLinkedTable(unitSpecialtiesList, "Transport_Category");

                writeDataLines(xssfSheet, unitInitalFlagsetSheet, unitTTagsModuleDescriptorSheet, unitSearchedTagsInEngagementRange,
                        unitIdentifiedTextureValues, unitUnidentifiedTextureValues, unitSpecialtiesList, transporterCategories,
                        transportableTagset);


                FileOutputStream outputStream = new FileOutputStream(excelFilePath);
                xssfWorkbook.write(outputStream);
                xssfWorkbook.close();
                outputStream.close();

            }catch (Exception e){
               System.out.println(e.getMessage());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Please delete your current UniteDescriptor.xlsx to import a new one");
        }
    }


    private void writeHeaderLine(XSSFSheet sheet){
        XSSFRow headerRow = sheet.createRow(0);

        XSSFCell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("referenceId");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Descriptor");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Nationalite");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("MotherCountry");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("AcknowUnitType");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("TypeUnitFormation");

        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("UseFollowCam");

        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("StickToGround");

        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("InGeoDb");

        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("PorteurMustBeVisible");

        headerCell = headerRow.createCell(10);
        headerCell.setCellValue("ClampInWorld");

        headerCell = headerRow.createCell(11);
        headerCell.setCellValue("ClampOutMap");

        headerCell = headerRow.createCell(12);
        headerCell.setCellValue("RelativeScanningPosition");

        headerCell = headerRow.createCell(13);
        headerCell.setCellValue("LowAltitudeFlyingAltitude");

        headerCell = headerRow.createCell(14);
        headerCell.setCellValue("NearGroundFlyingAltitude");

        headerCell = headerRow.createCell(15);
        headerCell.setCellValue("ExperienceLevelsPackDescriptor");

        headerCell = headerRow.createCell(16);
        headerCell.setCellValue("CanWinExperience");

        headerCell = headerRow.createCell(17);
        headerCell.setCellValue("ExperienceGainBySecond");

        headerCell = headerRow.createCell(18);
        headerCell.setCellValue("ExperienceMultiplierBonusOnKill");

        headerCell = headerRow.createCell(19);
        headerCell.setCellValue("AutoRevealType");

        headerCell = headerRow.createCell(20);
        headerCell.setCellValue("UnitConcealmentBonus");

        headerCell = headerRow.createCell(21);
        headerCell.setCellValue("VisionUnitType");

        headerCell = headerRow.createCell(22);
        headerCell.setCellValue("UnitIsStealth");

        headerCell = headerRow.createCell(23);
        headerCell.setCellValue("HideFromDebug");

        headerCell = headerRow.createCell(24);
        headerCell.setCellValue("PickableObject");

        headerCell = headerRow.createCell(25);
        headerCell.setCellValue("Depiction");

        headerCell = headerRow.createCell(26);
        headerCell.setCellValue("GhostDepiction");

        headerCell = headerRow.createCell(27);
        headerCell.setCellValue("BlackHoleIdentifier");

        headerCell = headerRow.createCell(28);
        headerCell.setCellValue("GameplayBBoxBoneName");

        headerCell = headerRow.createCell(29);
        headerCell.setCellValue("AutoCoverRange");

        headerCell = headerRow.createCell(30);
        headerCell.setCellValue("OccupationRadius");

        headerCell = headerRow.createCell(31);
        headerCell.setCellValue("TerrainListMask");

        headerCell = headerRow.createCell(32);
        headerCell.setCellValue("TerrainList");

        headerCell = headerRow.createCell(33);
        headerCell.setCellValue("UseTerrainsForEscape");

        headerCell = headerRow.createCell(34);
        headerCell.setCellValue("WeaponManagerDefault");

        headerCell = headerRow.createCell(35);
        headerCell.setCellValue("WeaponManagerSelection");

        headerCell = headerRow.createCell(36);
        headerCell.setCellValue("SuppressDamagesRegenRatio");

        headerCell = headerRow.createCell(37);
        headerCell.setCellValue("SuppressDamagesRegenRatioOutOfRange");

        headerCell = headerRow.createCell(38);
        headerCell.setCellValue("StunDamagesRegen");

        headerCell = headerRow.createCell(39);
        headerCell.setCellValue("StunFreezesUnits");

        headerCell = headerRow.createCell(40);
        headerCell.setCellValue("BlindageProperties");

        headerCell = headerRow.createCell(41);
        headerCell.setCellValue("ArmorDescriptorFront");

        headerCell = headerRow.createCell(42);
        headerCell.setCellValue("ArmorDescriptorSides");

        headerCell = headerRow.createCell(43);
        headerCell.setCellValue("ArmorDescriptorRear");

        headerCell = headerRow.createCell(44);
        headerCell.setCellValue("ArmorDescriptorTop");

        headerCell = headerRow.createCell(45);
        headerCell.setCellValue("MaxSuppressionDamages");

        headerCell = headerRow.createCell(46);
        headerCell.setCellValue("MaxStunDamages");

        headerCell = headerRow.createCell(47);
        headerCell.setCellValue("MaxDamages");

        headerCell = headerRow.createCell(48);
        headerCell.setCellValue("KillWhenDamagesReachMax");


        headerCell = headerRow.createCell(49);
        headerCell.setCellValue("HitRollSize");

        headerCell = headerRow.createCell(50);
        headerCell.setCellValue("HitRollECM");

        headerCell = headerRow.createCell(51);
        headerCell.setCellValue("AutoOrientation");

        headerCell = headerRow.createCell(52);
        headerCell.setCellValue("SkipCadavreCreation");

        headerCell = headerRow.createCell(53);
        headerCell.setCellValue("UseTopArmorAgainstFire");

        headerCell = headerRow.createCell(54);
        headerCell.setCellValue("PhysicalDamageLevelsPack");

        headerCell = headerRow.createCell(55);
        headerCell.setCellValue("SuppressDamageLevelsPack");

        headerCell = headerRow.createCell(56);
        headerCell.setCellValue("StunDamageLevelsPack");

        headerCell = headerRow.createCell(57);
        headerCell.setCellValue("Dangerousness");

        headerCell = headerRow.createCell(58);
        headerCell.setCellValue("MoralLevel");

        headerCell = headerRow.createCell(59);
        headerCell.setCellValue("MaxSpeed");

        headerCell = headerRow.createCell(60);
        headerCell.setCellValue("UnitMovingType");

        headerCell = headerRow.createCell(61);
        headerCell.setCellValue("PathfindType");

        headerCell = headerRow.createCell(62);
        headerCell.setCellValue("PreferredLayerMask");

        headerCell = headerRow.createCell(63);
        headerCell.setCellValue("VitesseCombat");

        headerCell = headerRow.createCell(64);
        headerCell.setCellValue("SpeedBonusOnRoad");

        headerCell = headerRow.createCell(65);
        headerCell.setCellValue("MaxAcceleration");

        headerCell = headerRow.createCell(66);
        headerCell.setCellValue("MaxDeceleration");

        headerCell = headerRow.createCell(67);
        headerCell.setCellValue("TempsDemiTour");

        headerCell = headerRow.createCell(68);
        headerCell.setCellValue("VehicleSubType");

        headerCell = headerRow.createCell(69);
        headerCell.setCellValue("StartTime");

        headerCell = headerRow.createCell(70);
        headerCell.setCellValue("StopTime");

        headerCell = headerRow.createCell(71);
        headerCell.setCellValue("RotationStartTime");

        headerCell = headerRow.createCell(72);
        headerCell.setCellValue("RotationStopTime");

        headerCell = headerRow.createCell(73);
        headerCell.setCellValue("FuelCapacity");

        headerCell = headerRow.createCell(74);
        headerCell.setCellValue("FuelMoveDuration");

        headerCell = headerRow.createCell(75);
        headerCell.setCellValue("OpticsAltitudeConfig");

        headerCell = headerRow.createCell(76);
        headerCell.setCellValue("DoesNotCountInScannerAbsoluteMaxRange");

        headerCell = headerRow.createCell(77);
        headerCell.setCellValue("PorteeVisionTBA");

        headerCell = headerRow.createCell(78);
        headerCell.setCellValue("PorteeVisionFOW");

        headerCell = headerRow.createCell(79);
        headerCell.setCellValue("DetectionTBA");

        headerCell = headerRow.createCell(80);
        headerCell.setCellValue("PorteeVision");

        headerCell = headerRow.createCell(81);
        headerCell.setCellValue("PorteeIdentification");

        headerCell = headerRow.createCell(82);
        headerCell.setCellValue("OpticalStrength");

        headerCell = headerRow.createCell(83);
        headerCell.setCellValue("OpticalStrengthAltitude");

        headerCell = headerRow.createCell(84);
        headerCell.setCellValue("UnitDetectStealthUnit");

        headerCell = headerRow.createCell(85);
        headerCell.setCellValue("SpecializedDetections");

        headerCell = headerRow.createCell(86);
        headerCell.setCellValue("SpecializedOpticalStrengths");

        headerCell = headerRow.createCell(87);
        headerCell.setCellValue("IgnoreObstacles");

        headerCell = headerRow.createCell(88);
        headerCell.setCellValue("IdentifyBaseProbability");

        headerCell = headerRow.createCell(89);
        headerCell.setCellValue("TimeBetweenEachIdentifyRoll");

        headerCell = headerRow.createCell(90);
        headerCell.setCellValue("VisibilityRuleDescriptor");

        headerCell = headerRow.createCell(91);
        headerCell.setCellValue("DistanceMultiplierRule");

        headerCell = headerRow.createCell(92);
        headerCell.setCellValue("MultiplicateurAPorteeMaximale");

        headerCell = headerRow.createCell(93);
        headerCell.setCellValue("MultiplicateurAPorteeMinimale");

        headerCell = headerRow.createCell(94);
        headerCell.setCellValue("Exposant");

        headerCell = headerRow.createCell(95);
        headerCell.setCellValue("MultiplicateurAPorteeMaximaleEnMouvement");

        headerCell = headerRow.createCell(96);
        headerCell.setCellValue("MultiplicateurAPorteeMinimaleEnMouvement");

        headerCell = headerRow.createCell(97);
        headerCell.setCellValue("ExposantEnMouvement");

        headerCell = headerRow.createCell(98);
        headerCell.setCellValue("IsTransport");

        headerCell = headerRow.createCell(99);
        headerCell.setCellValue("TransportedTexture");

        headerCell = headerRow.createCell(100);
        headerCell.setCellValue("TransportedSoldier");

        headerCell = headerRow.createCell(101);
        headerCell.setCellValue("TimeToLoad");

        headerCell = headerRow.createCell(102);
        headerCell.setCellValue("NbSeatsOccupied");

        headerCell = headerRow.createCell(103);
        headerCell.setCellValue("IsTowable");

        headerCell = headerRow.createCell(104);
        headerCell.setCellValue("NbSeatsAvailable");

        headerCell = headerRow.createCell(105);
        headerCell.setCellValue("WreckUnloadPhysicalDamageBonus");

        headerCell = headerRow.createCell(106);
        headerCell.setCellValue("WreckUnloadSuppressDamageBonus");

        headerCell = headerRow.createCell(107);
        headerCell.setCellValue("WreckUnloadStunDamageBonus");

        headerCell = headerRow.createCell(108);
        headerCell.setCellValue("LoadRadius");

        headerCell = headerRow.createCell(109);
        headerCell.setCellValue("Factory");

        headerCell = headerRow.createCell(110);
        headerCell.setCellValue("ProductionTime");

        headerCell = headerRow.createCell(111);
        headerCell.setCellValue("CommandPoints");

        headerCell = headerRow.createCell(112);
        headerCell.setCellValue("ResourceTickets");

        headerCell = headerRow.createCell(113);
        headerCell.setCellValue("CanAssist");

        headerCell = headerRow.createCell(114);
        headerCell.setCellValue("AssistRequestBroadcastRadius");

        headerCell = headerRow.createCell(115);
        headerCell.setCellValue("DistanceToFlee");

        headerCell = headerRow.createCell(116);
        headerCell.setCellValue("MaxDistanceForOffensiveReaction");

        headerCell = headerRow.createCell(117);
        headerCell.setCellValue("MaxDistanceForOffensiveReactionOnFlyingTarget");

        headerCell = headerRow.createCell(118);
        headerCell.setCellValue("MaxDistanceForEngagement");

        headerCell = headerRow.createCell(119);
        headerCell.setCellValue("MinimapDisplayTexture");

        headerCell = headerRow.createCell(120);
        headerCell.setCellValue("MinimapDisplayGhostTexture");

        headerCell = headerRow.createCell(121);
        headerCell.setCellValue("MinimapDisplayIsAlwaysVisible");

        headerCell = headerRow.createCell(122);
        headerCell.setCellValue("MinimapDisplayUseTeamColor");

        headerCell = headerRow.createCell(123);
        headerCell.setCellValue("MinimapDisplayFollowUnitOrientation");

        headerCell = headerRow.createCell(124);
        headerCell.setCellValue("ValidOrders");

        headerCell = headerRow.createCell(125);
        headerCell.setCellValue("UnlockableOrders");

        headerCell = headerRow.createCell(126);
        headerCell.setCellValue("MultiSelectionSortingOrder");

        headerCell = headerRow.createCell(127);
        headerCell.setCellValue("UnitName");

        headerCell = headerRow.createCell(128);
        headerCell.setCellValue("IdentifiedTexture");

        headerCell = headerRow.createCell(129);
        headerCell.setCellValue("IdentifiedTextureCommandNameTrigger");

        headerCell = headerRow.createCell(130);
        headerCell.setCellValue("IdentifiedTextureAlterator");

        headerCell = headerRow.createCell(131);
        headerCell.setCellValue("DefaultSpecialtyToken");

        headerCell = headerRow.createCell(132);
        headerCell.setCellValue("UnidentifiedTexture");

        headerCell = headerRow.createCell(133);
        headerCell.setCellValue("UnidentifiedTextureCommandNameTrigger");

        headerCell = headerRow.createCell(134);
        headerCell.setCellValue("UnidentifiedTextureAlterator");

        headerCell = headerRow.createCell(135);
        headerCell.setCellValue("PositionHeightOffset");

        headerCell = headerRow.createCell(136);
        headerCell.setCellValue("NbSoldiers");

        headerCell = headerRow.createCell(137);
        headerCell.setCellValue("EvacuationTime");

        headerCell = headerRow.createCell(138);
        headerCell.setCellValue("TravelDuration");

        headerCell = headerRow.createCell(139);
        headerCell.setCellValue("UnitAttackValue");

        headerCell = headerRow.createCell(140);
        headerCell.setCellValue("UnitDefenseValue");

        headerCell = headerRow.createCell(141);
        headerCell.setCellValue("UnitBonusXpPerLevelValue");

        headerCell = headerRow.createCell(142);
        headerCell.setCellValue("UnitRole");

        headerCell = headerRow.createCell(143);
        headerCell.setCellValue("NameToken");

        headerCell = headerRow.createCell(144);
        headerCell.setCellValue("InfoPanelConfigurationToken");

        headerCell = headerRow.createCell(145);
        headerCell.setCellValue("TypeSpecificToken");

        headerCell = headerRow.createCell(146);
        headerCell.setCellValue("RealRoadSpeed");

        headerCell = headerRow.createCell(147);
        headerCell.setCellValue("IsAce");

        headerCell = headerRow.createCell(148);
        headerCell.setCellValue("UpgradeFromUnit");

        headerCell = headerRow.createCell(149);
        headerCell.setCellValue("GenerateName");

        headerCell = headerRow.createCell(150);
        headerCell.setCellValue("MenuIconTexture");

        headerCell = headerRow.createCell(151);
        headerCell.setCellValue("ButtonTexture");

        headerCell = headerRow.createCell(152);
        headerCell.setCellValue("CountryTexture");

        headerCell = headerRow.createCell(153);
        headerCell.setCellValue("TypeStrategicCount");
    }

    private void writeHeaderLinkedTable(XSSFSheet sheet, String str){

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("unitReferenceId");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue(str);
    }

    private void writeDataLines(XSSFSheet sheet, XSSFSheet sheet1, XSSFSheet sheet2, XSSFSheet sheet3, XSSFSheet sheet4,
                                XSSFSheet sheet5, XSSFSheet sheet6, XSSFSheet sheet7, XSSFSheet sheet8){
        int rowCount = 1;
        int rowCountInitialFlagSet = 1;
        int rowCountTTagsModuleDescriptor = 1;
        int rowCountSearchedTagsInEngagementTarge = 1;
        int rowCountIdentifiedTextureValues = 1;
        int rowCountUnidentifiedTextureTextureValues = 1;
        int rowCountSpecialtiesList = 1;
        int rowCountTransporterCategories= 1;
        int rowCountTransportableTagSet = 1;


        for (UniteDescriptor uniteDescriptor : uniteDescriptorList) {
            int columnCount = 0;

            Row row = sheet.createRow(rowCount++);
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getReferenceId());

            cell = row.createCell(columnCount++);
            if(uniteDescriptor.getDescriptor() != null) {
                cell.setCellValue(uniteDescriptor.getDescriptor());
            }else{
                cell.setCellValue("Null");
            }

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getNationalite());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMotherCountry());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getAcknowUnitType());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTypeUnitFormation());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getUseFollowCam()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getStickToGround()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getInGeoDb()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getPorteurMustBeVisible()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getClampInWorld()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getClampOutMap()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getRelativeScanningPosition());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getLowAltitudeFlyingAltitude());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getNearGroundFlyingAltitude());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getExperienceLevelsPackDescriptor());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getCanWinExperience()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getExperienceGainBySecond());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getExperienceMultiplierBonusOnKill());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getAutoRevealType());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitConcealmentBonus());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getVisionUnitType());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getUnitIsStealth()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getHideFromDebug()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getPickableObject()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getDepiction());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getGhostDepiction());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getBlackHoleIdentifier());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getGameplayBBoxBoneName());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getAutoCoverRange());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getOccupationRadius());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTerrainListMask());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTerrainList());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getUseTerrainsForEscape()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getWeaponManagerDefault());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getWeaponManagerSelection());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getSuppressDamagesRegenRatio());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getSuppressDamagesRegenRatioOutOfRange());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getStunDamagesRegen());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getStunFreezesUnits());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getBlindageProperties());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getArmorDescriptorFront());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getArmorDescriptorSides());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getArmorDescriptorRear());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getArmorDescriptorTop());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxSuppressionDamages());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxStunDamages());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxDamages());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getKillWhenDamagesReachMax()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getHitRollSize());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getHitRollECM());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getAutoOrientation()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getSkipCadavreCreation()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getUseTopArmorAgainstFire()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPhysicalDamageLevelsPack());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getSuppressDamageLevelsPack());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getStunDamageLevelsPack());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getDangerousness());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMoralLevel());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxSpeed());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitMovingType());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPathfindType());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPreferredLayerMask());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getVitesseCombat());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getSpeedBonusOnRoad());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxAcceleration());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxDeceleration());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTempsDemiTour());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getVehicleSubType());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getStartTime());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getStopTime());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getRotationStartTime());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getRotationStopTime());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getFuelCapacity());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getFuelMoveDuration());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getOpticsAltitudeConfig());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getDoesNotCountInScannerAbsoluteMaxRange()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPorteeVisionTBA());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPorteeVisionFOW());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getDetectionTBA());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPorteeVision());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPorteeIdentification());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getOpticalStrength());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getOpticalStrengthAltitude());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getUnitDetectStealthUnit()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getSpecializedDetections());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getSpecializedOpticalStrengths());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getIgnoreObstacles());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getIdentifyBaseProbability());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTimeBetweenEachIdentifyRoll());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getVisibilityRuleDescriptor());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getDistanceMultiplierRule());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMultiplicateurAPorteeMaximale());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMultiplicateurAPorteeMinimale());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getExposant());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMultiplicateurAPorteeMaximaleEnMouvement());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMultiplicateurAPorteeMinimaleEnMouvement());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getExposantEnMouvement());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getIsTransport()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTransportedTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTransportedSoldier());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTimeToLoad());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getNbSeatsOccupied());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getIsTowable()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getNbSeatsAvailable());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getWreckUnloadPhysicalDamageBonus());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getWreckUnloadSuppressDamageBonus());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getWreckUnloadStunDamageBonus());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getLoadRadius());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getFactory());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getProductionTime());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getCommandPoints());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getResourceTickets());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getCanAssist()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getAssistRequestBroadcastRadius());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getDistanceToFlee());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxDistanceForOffensiveReaction());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxDistanceForOffensiveReactionOnFlyingTarget());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMaxDistanceForEngagement());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMinimapDisplayTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMinimapDisplayGhostTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getMinimapDisplayIsAlwaysVisible()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getMinimapDisplayUseTeamColor()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getMinimapDisplayFollowUnitOrientation()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getValidOrders());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnlockableOrders());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMultiSelectionSortingOrder());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitName());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getIdentifiedTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getIdentifiedTextureCommandNameTrigger());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getIdentifiedTextureAlterator());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getDefaultSpeciailtyToken());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnidentifiedTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnidentifiedTextureCommandNameTrigger());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnidentifiedTextureAlterator());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getPositionHeightOffset());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getNbSoldiers());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getEvacuationTime());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTravelDuration());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitAttackValue());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitDefenseValue());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitBonusXpPerLevelValue());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUnitRole());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getNameToken());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getInfoPanelConfigurationToken());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getTypeSpecificToken());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getRealRoadSpeed());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getIsAce()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getUpgradeFromUnit());

            cell = row.createCell(columnCount++);
            cell.setCellValue(String.valueOf(uniteDescriptor.getGenerateName()));

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getMenuIconTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getButtonTexture());

            cell = row.createCell(columnCount++);
            cell.setCellValue(uniteDescriptor.getCountryTexture());

            cell = row.createCell(columnCount);
            cell.setCellValue(uniteDescriptor.getTypeStrategicCount());


            for (String flag : uniteDescriptor.getInitialFlagSet()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet1.createRow(rowCountInitialFlagSet++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(flag);

            }

            for (String module : uniteDescriptor.getTTagsModuleDescriptor()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet2.createRow(rowCountTTagsModuleDescriptor++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(module);

            }

            for (String searchedTag : uniteDescriptor.getSearchedTagsInEngagementTarget()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet3.createRow(rowCountSearchedTagsInEngagementTarge++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(searchedTag);
            }

            for (String textureValue : uniteDescriptor.getIdentifiedTextureValues()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet4.createRow(rowCountIdentifiedTextureValues++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(textureValue);
            }

            for (String textureValue : uniteDescriptor.getUnidentifiedTextureTextureValues()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet5.createRow(rowCountUnidentifiedTextureTextureValues++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(textureValue);
            }

            for (String specialty : uniteDescriptor.getSpecialtiesList()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet6.createRow(rowCountSpecialtiesList++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(specialty);
            }
            for (String category : uniteDescriptor.getTransporterCategories()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet7.createRow(rowCountTransporterCategories++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(category);
            }

            for (String tagSet : uniteDescriptor.getTransportableTagSet()) {
                int columnCountLinkedTables = 0;
                Row rowLT = sheet8.createRow(rowCountTransportableTagSet++);

                Cell cellLT = rowLT.createCell(columnCountLinkedTables++);
                cellLT.setCellValue(uniteDescriptor.getReferenceId());

                cellLT = rowLT.createCell(columnCountLinkedTables);
                cellLT.setCellValue(tagSet);
            }
        }


    }

}





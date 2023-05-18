package org.TalCoWarPro.UniteDescriptorRequestExcel;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Formatter;

public class UniteDescriptorRequestExcel {
    ArrayList<UniteDescriptor> uniteDescList;
    DataFormatter formatter;
    int referenceId;
    String descriptor;
    String nationalite;
    String motherCountry;
    String acknowUnitType;
    String typeUnitFormation;
    Boolean useFollowCam;
    Boolean stickToGround;
    Boolean inGeoDb;
    Boolean porteurMustBeVisible;
    Boolean clampInWorld;
    Boolean clampOutMap;
    String relativeScanningPosition;
    String lowAltitudeFlyingAltitude;
    String nearGroundFlyingAltitude;
    String experienceLevelsPackDescriptor;
    Boolean canWinExperience;
    String experienceGainBySecond;
    String experienceMultiplierBonusOnKill;
    String autoRevealType;
    String unitConcealmentBonus;
    String visionUnitType;
    Boolean unitIsStealth;
    Boolean hideFromDebug;
    Boolean pickableObject;
    String depiction;
    String ghostDepiction;
    String blackHoleIdentifier;
    String gameplayBBoxBoneName;
    String autoCoverRange;
    String occupationRadius;
    String terrainListMask;
    String terrainList;
    Boolean useTerrainsForEscape;
    String weaponManagerDefault;
    String weaponManagerSelection;
    String suppressDamagesRegenRatio;
    String suppressDamagesRegenRatioOutOfRange;
    String stunDamagesRegen;
    Boolean stunFreezesUnits;
    String blindageProperties;
    String armorDescriptorFront;
    String armorDescriptorSides;
    String armorDescriptorRear;
    String armorDescriptorTop;
    String maxSuppressionDamages;
    String maxStunDamages;
    String maxDamages;
    Boolean killWhenDamagesReachMax;
    String hitRollSize;
    String hitRollECM;
    Boolean autoOrientation;
    Boolean skipCadavreCreation;
    Boolean useTopArmorAgainstFire;
    String physicalDamageLevelsPack;
    String suppressDamageLevelsPack;
    String stunDamageLevelsPack;
    String dangerousness;
    String moralLevel;
    String maxSpeed;
    String unitMovingType;
    String pathfindType;
    String preferredLayerMask;
    String vitesseCombat;
    String speedBonusOnRoad;
    String maxAcceleration;
    String maxDeceleration;
    String tempsDemiTour;
    String vehicleSubType;
    String startTime;
    String stopTime;
    String rotationStartTime;
    String rotationStopTime;
    String fuelCapacity;
    String fuelMoveDuration;
    String opticsAltitudeConfig;
    Boolean doesNotCountInScannerAbsoluteMaxRange;
    String porteeVisionTBA;
    String porteeVisionFOW;
    String detectionTBA;
    String porteeVision;
    String porteeIdentification;
    String opticalStrength;
    String opticalStrengthAltitude;
    Boolean unitDetectStealthUnit;
    String specializedDetections;
    String specializedOpticalStrengths;
    String ignoreObstacles;
    String identifyBaseProbability;
    String timeBetweenEachIdentifyRoll;
    String visibilityRuleDescriptor;
    String distanceMultiplierRule;
    String multiplicateurAPorteeMaximale;
    String multiplicateurAPorteeMinimale;
    String exposant;
    String multiplicateurAPorteeMaximaleEnMouvement;
    String multiplicateurAPorteeMinimaleEnMouvement;
    String exposantEnMouvement;
    Boolean isTransport;
    String transportedTexture;
    String transportedSoldier;
    String timeToLoad;
    String nbSeatsOccupied;
    Boolean isTowable;
    String nbSeatsAvailable;
    String wreckUnloadPhysicalDamageBonus;
    String wreckUnloadSuppressDamageBonus;
    String wreckUnloadStunDamageBonus;
    String loadRadius;
    String factory;
    String productionTime;
    String commandPoints;
    String resourceTickets;
    Boolean canAssist;
    String assistRequestBroadcastRadius;
    String distanceToFlee;
    String maxDistanceForOffensiveReaction;
    String maxDistanceForOffensiveReactionOnFlyingTarget;
    String maxDistanceForEngagement;
    String minimapDisplayTexture;
    String minimapDisplayGhostTexture;
    Boolean minimapDisplayIsAlwaysVisible;
    Boolean minimapDisplayUseTeamColor;
    Boolean minimapDisplayFollowUnitOrientation;
    String validOrders;
    String unlockableOrders;
    String multiSelectionSortingOrder;
    String unitName;
    String identifiedTexture;
    String identifiedTextureCommandNameTrigger;
    String identifiedTextureAlterator;
    String defaultSpeciailtyToken;
    String unidentifiedTexture;
    String unidentifiedTextureCommandNameTrigger;
    String unidentifiedTextureAlterator;
    String positionHeightOffset;
    String nbSoldiers;
    String evacuationTime;
    String travelDuration;
    String unitAttackValue;
    String unitDefenseValue;
    String unitBonusXpPerLevelValue;
    String unitRole;
    String nameToken;
    String infoPanelConfigurationToken;
    String typeSpecificToken;
    String realRoadSpeed;
    Boolean isAce;
    String upgradeFromUnit;
    Boolean generateName;
    String menuIconTexture;
    String buttonTexture;
    String countryTexture;
    String typeStrategicCount;

    public ArrayList<UniteDescriptor> readUniteDescriptor() {
        uniteDescList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("Output\\UniteDescriptorExcel.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("Unite Descriptor");
            unloadSheet(xssfSheet);
            XSSFSheet unitInitalFlagsetSheet = xssfWorkbook.getSheet("Inital Flagset");
            unloadInitalFlagsetSheet(unitInitalFlagsetSheet);
            XSSFSheet unitTTagsModuleDescriptorSheet = xssfWorkbook.getSheet("Ttags Module Descriptor");
            unloadTTagsModuleDescriptorSheet(unitTTagsModuleDescriptorSheet);
            XSSFSheet unitSearchedTagsInEngagementRange = xssfWorkbook.getSheet("Tags In Engagement Range");
            unloadSearchedTagsInEngagementRange(unitSearchedTagsInEngagementRange);
            XSSFSheet unitIdentifiedTextureValues = xssfWorkbook.getSheet("Identified Texture Values");
            unloadIdentifiedTextureValues(unitIdentifiedTextureValues);
            XSSFSheet unitUnidentifiedTextureValues = xssfWorkbook.getSheet("Unidentified Texture Values");
            unloadUnidentifiedTextureValues(unitUnidentifiedTextureValues);
            XSSFSheet unitSpecialtiesList = xssfWorkbook.getSheet("Specialties List");
            unloadUnitSpecialtiesList(unitSpecialtiesList);
            XSSFSheet transporterCategories = xssfWorkbook.getSheet("Transporter Categories");
            unloadTransporterCategories(transporterCategories);
            XSSFSheet transportableTagset = xssfWorkbook.getSheet("Transportable Tagset");
            unloadTransportableTagset(transportableTagset);
            xssfWorkbook.close();
            fis.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return uniteDescList;
    }

    private void unloadSheet(XSSFSheet sheet){
        int rows = sheet.getLastRowNum();

        formatter = new DataFormatter();

        for (int r = 1; r <= rows; r++){
            XSSFRow row = sheet.getRow(r);

            try {
                referenceId = Integer.parseInt(formatter.formatCellValue(row.getCell(0)));
                descriptor = formatter.formatCellValue(row.getCell(1));
                if (descriptor.contains("ATAS")) {
                    System.out.println("test");
                }
                nationalite = formatter.formatCellValue(row.getCell(2));
                motherCountry = formatter.formatCellValue(row.getCell(3));
                acknowUnitType = formatter.formatCellValue(row.getCell(4));
                typeUnitFormation = formatter.formatCellValue(row.getCell(5));
                useFollowCam = Boolean.valueOf(formatter.formatCellValue(row.getCell(6)));
                stickToGround = Boolean.valueOf(formatter.formatCellValue(row.getCell(7)));
                inGeoDb = Boolean.valueOf(formatter.formatCellValue(row.getCell(8)));
                porteurMustBeVisible = Boolean.valueOf(formatter.formatCellValue(row.getCell(9)));
                clampInWorld = Boolean.valueOf(formatter.formatCellValue(row.getCell(10)));
                clampOutMap = Boolean.valueOf(formatter.formatCellValue(row.getCell(11)));
                relativeScanningPosition = formatter.formatCellValue(row.getCell(12));
                lowAltitudeFlyingAltitude = formatter.formatCellValue(row.getCell(13));
                nearGroundFlyingAltitude = formatter.formatCellValue(row.getCell(14));
                experienceLevelsPackDescriptor = formatter.formatCellValue(row.getCell(15));
                canWinExperience = Boolean.valueOf(formatter.formatCellValue(row.getCell(16)));
                experienceGainBySecond = formatter.formatCellValue(row.getCell(17));
                experienceMultiplierBonusOnKill = formatter.formatCellValue(row.getCell(18));
                autoRevealType = formatter.formatCellValue(row.getCell(19));
                unitConcealmentBonus = formatter.formatCellValue(row.getCell(20));
                visionUnitType = formatter.formatCellValue(row.getCell(21));
                unitIsStealth = Boolean.valueOf(formatter.formatCellValue(row.getCell(22)));
                hideFromDebug = Boolean.valueOf(formatter.formatCellValue(row.getCell(23)));
                pickableObject = Boolean.valueOf(formatter.formatCellValue(row.getCell(24)));
                depiction = formatter.formatCellValue(row.getCell(25));
                ghostDepiction = formatter.formatCellValue(row.getCell(26));
                blackHoleIdentifier = formatter.formatCellValue(row.getCell(27));
                gameplayBBoxBoneName = formatter.formatCellValue(row.getCell(28));
                autoCoverRange = formatter.formatCellValue(row.getCell(29));
                occupationRadius = formatter.formatCellValue(row.getCell(30));
                terrainListMask = formatter.formatCellValue(row.getCell(31));
                terrainList = formatter.formatCellValue(row.getCell(32));
                String test = row.getCell(33).getStringCellValue();
                if (test.equals("null")) {
                    useTerrainsForEscape = null;
                } else {
                    useTerrainsForEscape = Boolean.valueOf(formatter.formatCellValue(row.getCell(33)));
                }
                weaponManagerDefault = formatter.formatCellValue(row.getCell(34));
                weaponManagerSelection = formatter.formatCellValue(row.getCell(35));
                suppressDamagesRegenRatio = formatter.formatCellValue(row.getCell(36));
                suppressDamagesRegenRatioOutOfRange = formatter.formatCellValue(row.getCell(37));
                stunDamagesRegen = formatter.formatCellValue(row.getCell(38));
                stunFreezesUnits = Boolean.valueOf(formatter.formatCellValue(row.getCell(39)));
                blindageProperties = formatter.formatCellValue(row.getCell(40));
                armorDescriptorFront = formatter.formatCellValue(row.getCell(41));
                armorDescriptorSides = formatter.formatCellValue(row.getCell(42));
                armorDescriptorRear = formatter.formatCellValue(row.getCell(43));
                armorDescriptorTop = formatter.formatCellValue(row.getCell(44));
                maxSuppressionDamages = formatter.formatCellValue(row.getCell(45));
                maxStunDamages = formatter.formatCellValue(row.getCell(46));
                maxDamages = formatter.formatCellValue(row.getCell(47));
                killWhenDamagesReachMax = Boolean.valueOf(formatter.formatCellValue(row.getCell(48)));
                hitRollSize = formatter.formatCellValue(row.getCell(49));
                hitRollECM = formatter.formatCellValue(row.getCell(50));
                autoOrientation = Boolean.valueOf(formatter.formatCellValue(row.getCell(51)));
                skipCadavreCreation = Boolean.valueOf(formatter.formatCellValue(row.getCell(52)));
                useTopArmorAgainstFire = Boolean.valueOf(formatter.formatCellValue(row.getCell(53)));
                physicalDamageLevelsPack = formatter.formatCellValue(row.getCell(54));
                suppressDamageLevelsPack = formatter.formatCellValue(row.getCell(55));
                stunDamageLevelsPack = formatter.formatCellValue(row.getCell(56));
                dangerousness = formatter.formatCellValue(row.getCell(57));
                moralLevel = formatter.formatCellValue(row.getCell(58));
                maxSpeed = formatter.formatCellValue(row.getCell(59));

                unitMovingType = formatter.formatCellValue(row.getCell(60));

                pathfindType = formatter.formatCellValue(row.getCell(61));
                preferredLayerMask = formatter.formatCellValue(row.getCell(62));
                vitesseCombat = formatter.formatCellValue(row.getCell(63));
                speedBonusOnRoad = formatter.formatCellValue(row.getCell(64));
                maxAcceleration = formatter.formatCellValue(row.getCell(65));
                maxDeceleration = formatter.formatCellValue(row.getCell(66));
                tempsDemiTour = formatter.formatCellValue(row.getCell(67));
                vehicleSubType = formatter.formatCellValue(row.getCell(68));
                startTime = formatter.formatCellValue(row.getCell(69));
                stopTime = formatter.formatCellValue(row.getCell(70));
                rotationStartTime = formatter.formatCellValue(row.getCell(71));
                rotationStopTime = formatter.formatCellValue(row.getCell(72));
                fuelCapacity = formatter.formatCellValue(row.getCell(73));
                fuelMoveDuration = formatter.formatCellValue(row.getCell(74));

                opticsAltitudeConfig = formatter.formatCellValue(row.getCell(75));
                doesNotCountInScannerAbsoluteMaxRange = Boolean.valueOf(formatter.formatCellValue(row.getCell(76)));
                porteeVisionTBA = formatter.formatCellValue(row.getCell(77));
                porteeVisionFOW = formatter.formatCellValue(row.getCell(78));
                detectionTBA = formatter.formatCellValue(row.getCell(79));
                porteeVision = formatter.formatCellValue(row.getCell(80));
                porteeIdentification = formatter.formatCellValue(row.getCell(81));
                opticalStrength = formatter.formatCellValue(row.getCell(82));
                opticalStrengthAltitude = formatter.formatCellValue(row.getCell(83));
                unitDetectStealthUnit = Boolean.valueOf(formatter.formatCellValue(row.getCell(84)));
                specializedDetections = formatter.formatCellValue(row.getCell(85));
                specializedOpticalStrengths = formatter.formatCellValue(row.getCell(86));
                ignoreObstacles = formatter.formatCellValue(row.getCell(87));
                identifyBaseProbability = formatter.formatCellValue(row.getCell(88));
                timeBetweenEachIdentifyRoll = formatter.formatCellValue(row.getCell(89));
                visibilityRuleDescriptor = formatter.formatCellValue(row.getCell(90));
                distanceMultiplierRule = formatter.formatCellValue(row.getCell(91));
                multiplicateurAPorteeMaximale = formatter.formatCellValue(row.getCell(92));
                multiplicateurAPorteeMinimale = formatter.formatCellValue(row.getCell(93));
                exposant = formatter.formatCellValue(row.getCell(94));
                multiplicateurAPorteeMaximaleEnMouvement = formatter.formatCellValue(row.getCell(95));
                multiplicateurAPorteeMinimaleEnMouvement = formatter.formatCellValue(row.getCell(96));
                exposantEnMouvement = formatter.formatCellValue(row.getCell(97));
                isTransport = Boolean.valueOf(formatter.formatCellValue(row.getCell(98)));
                transportedTexture = formatter.formatCellValue(row.getCell(99));
                transportedSoldier = formatter.formatCellValue(row.getCell(100));
                timeToLoad = formatter.formatCellValue(row.getCell(101));
                nbSeatsOccupied = formatter.formatCellValue(row.getCell(102));
                isTowable = Boolean.valueOf(formatter.formatCellValue(row.getCell(103)));
                nbSeatsAvailable = formatter.formatCellValue(row.getCell(104));
                wreckUnloadPhysicalDamageBonus = formatter.formatCellValue(row.getCell(105));
                wreckUnloadSuppressDamageBonus = formatter.formatCellValue(row.getCell(106));
                wreckUnloadStunDamageBonus = formatter.formatCellValue(row.getCell(107));
                loadRadius = formatter.formatCellValue(row.getCell(108));
                factory = formatter.formatCellValue(row.getCell(109));
                productionTime = formatter.formatCellValue(row.getCell(110));
                commandPoints = formatter.formatCellValue(row.getCell(111));
                resourceTickets = formatter.formatCellValue(row.getCell(112));
                canAssist = Boolean.valueOf(formatter.formatCellValue(row.getCell(113)));
                assistRequestBroadcastRadius = formatter.formatCellValue(row.getCell(114));
                distanceToFlee = formatter.formatCellValue(row.getCell(115));
                maxDistanceForOffensiveReaction = formatter.formatCellValue(row.getCell(116));
                maxDistanceForOffensiveReactionOnFlyingTarget = formatter.formatCellValue(row.getCell(117));
                maxDistanceForEngagement = formatter.formatCellValue(row.getCell(118));
                minimapDisplayTexture = formatter.formatCellValue(row.getCell(119));
                minimapDisplayGhostTexture = formatter.formatCellValue(row.getCell(120));
                minimapDisplayIsAlwaysVisible = Boolean.valueOf(formatter.formatCellValue(row.getCell(121)));
                minimapDisplayUseTeamColor = Boolean.valueOf(formatter.formatCellValue(row.getCell(122)));
                minimapDisplayFollowUnitOrientation = Boolean.valueOf(formatter.formatCellValue(row.getCell(123)));
                validOrders = formatter.formatCellValue(row.getCell(124));
                unlockableOrders = formatter.formatCellValue(row.getCell(125));
                multiSelectionSortingOrder = formatter.formatCellValue(row.getCell(126));
                unitName = formatter.formatCellValue(row.getCell(127));
                identifiedTexture = formatter.formatCellValue(row.getCell(128));
                identifiedTextureCommandNameTrigger = formatter.formatCellValue(row.getCell(129));
                identifiedTextureAlterator = formatter.formatCellValue(row.getCell(130));
                defaultSpeciailtyToken = formatter.formatCellValue(row.getCell(131));
                unidentifiedTexture = formatter.formatCellValue(row.getCell(132));
                unidentifiedTextureCommandNameTrigger = formatter.formatCellValue(row.getCell(133));
                unidentifiedTextureAlterator = formatter.formatCellValue(row.getCell(134));
                positionHeightOffset = formatter.formatCellValue(row.getCell(135));
                nbSoldiers = formatter.formatCellValue(row.getCell(136));
                evacuationTime = formatter.formatCellValue(row.getCell(137));
                travelDuration = formatter.formatCellValue(row.getCell(138));
                unitAttackValue = formatter.formatCellValue(row.getCell(139));
                unitDefenseValue = formatter.formatCellValue(row.getCell(140));
                unitBonusXpPerLevelValue = formatter.formatCellValue(row.getCell(141));
                unitRole = formatter.formatCellValue(row.getCell(142));
                nameToken = formatter.formatCellValue(row.getCell(143));
                infoPanelConfigurationToken = formatter.formatCellValue(row.getCell(144));
                typeSpecificToken = formatter.formatCellValue(row.getCell(145));
                realRoadSpeed = formatter.formatCellValue(row.getCell(146));
                isAce = Boolean.valueOf(formatter.formatCellValue(row.getCell(147)));
                upgradeFromUnit = formatter.formatCellValue(row.getCell(148));
                generateName = Boolean.valueOf(formatter.formatCellValue(row.getCell(149)));
                menuIconTexture = formatter.formatCellValue(row.getCell(150));
                buttonTexture = formatter.formatCellValue(row.getCell(151));
                countryTexture = formatter.formatCellValue(row.getCell(152));
                typeStrategicCount = formatter.formatCellValue(row.getCell(153));

                UniteDescriptor uniteDesc = new UniteDescriptor(referenceId, descriptor, nationalite, motherCountry,
                        acknowUnitType, typeUnitFormation,
                        useFollowCam, stickToGround, inGeoDb, porteurMustBeVisible, clampInWorld, clampOutMap,
                        relativeScanningPosition, lowAltitudeFlyingAltitude, nearGroundFlyingAltitude,
                        experienceLevelsPackDescriptor, canWinExperience, experienceGainBySecond,
                        experienceMultiplierBonusOnKill, autoRevealType, unitConcealmentBonus,
                        visionUnitType, unitIsStealth, hideFromDebug, pickableObject, depiction,
                        ghostDepiction, blackHoleIdentifier, gameplayBBoxBoneName, autoCoverRange,
                        occupationRadius, terrainListMask, terrainList, useTerrainsForEscape, weaponManagerDefault,
                        weaponManagerSelection, suppressDamagesRegenRatio, suppressDamagesRegenRatioOutOfRange,
                        stunDamagesRegen, stunFreezesUnits, blindageProperties, armorDescriptorFront,
                        armorDescriptorSides, armorDescriptorRear, armorDescriptorTop, maxSuppressionDamages,
                        maxStunDamages, maxDamages, killWhenDamagesReachMax, hitRollSize, hitRollECM,
                        autoOrientation, skipCadavreCreation, useTopArmorAgainstFire, physicalDamageLevelsPack,
                        suppressDamageLevelsPack, stunDamageLevelsPack, dangerousness, moralLevel, maxSpeed,
                        unitMovingType, pathfindType, preferredLayerMask, vitesseCombat, speedBonusOnRoad,
                        maxAcceleration, maxDeceleration, tempsDemiTour, vehicleSubType, startTime, stopTime,
                        rotationStartTime, rotationStopTime, fuelCapacity, fuelMoveDuration, opticsAltitudeConfig,
                        doesNotCountInScannerAbsoluteMaxRange, porteeVisionTBA, porteeVisionFOW, detectionTBA,
                        porteeVision, porteeIdentification, opticalStrength, opticalStrengthAltitude,
                        unitDetectStealthUnit, specializedDetections, specializedOpticalStrengths, ignoreObstacles,
                        identifyBaseProbability, timeBetweenEachIdentifyRoll, visibilityRuleDescriptor,
                        distanceMultiplierRule, multiplicateurAPorteeMaximale, multiplicateurAPorteeMinimale,
                        exposant, multiplicateurAPorteeMaximaleEnMouvement, multiplicateurAPorteeMinimaleEnMouvement,
                        exposantEnMouvement, isTransport, transportedTexture, transportedSoldier, timeToLoad,
                        nbSeatsOccupied, isTowable, nbSeatsAvailable, wreckUnloadPhysicalDamageBonus,
                        wreckUnloadSuppressDamageBonus, wreckUnloadStunDamageBonus, loadRadius, factory,
                        productionTime, commandPoints, resourceTickets, canAssist, assistRequestBroadcastRadius,
                        distanceToFlee, maxDistanceForOffensiveReaction, maxDistanceForOffensiveReactionOnFlyingTarget,
                        maxDistanceForEngagement, minimapDisplayTexture, minimapDisplayGhostTexture,
                        minimapDisplayIsAlwaysVisible, minimapDisplayUseTeamColor, minimapDisplayFollowUnitOrientation,
                        validOrders, unlockableOrders, multiSelectionSortingOrder, unitName, identifiedTexture,
                        identifiedTextureCommandNameTrigger, identifiedTextureAlterator, defaultSpeciailtyToken,
                        unidentifiedTexture, unidentifiedTextureCommandNameTrigger, unidentifiedTextureAlterator,
                        positionHeightOffset, nbSoldiers, evacuationTime, travelDuration, unitAttackValue,
                        unitDefenseValue, unitBonusXpPerLevelValue, unitRole, nameToken, infoPanelConfigurationToken,
                        typeSpecificToken, realRoadSpeed, isAce, upgradeFromUnit, generateName, menuIconTexture,
                        buttonTexture, countryTexture, typeStrategicCount);
                uniteDescList.add(uniteDesc);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void unloadInitalFlagsetSheet (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getInitialFlagSet();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setInitialFlagSet(tempList);
        }
    }
    private void unloadTTagsModuleDescriptorSheet  (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getTTagsModuleDescriptor();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setTTagsModuleDescriptor(tempList);
        }
    }
    private void unloadSearchedTagsInEngagementRange (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getSearchedTagsInEngagementTarget();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setSearchedTagsInEngagementTarget(tempList);
        }
    }
    private void unloadIdentifiedTextureValues (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getIdentifiedTextureValues();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setIdentifiedTextureValues(tempList);
        }
    }
    private void unloadUnidentifiedTextureValues (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getUnidentifiedTextureTextureValues();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setUnidentifiedTextureTextureValues(tempList);;
        }
    }
    private void unloadUnitSpecialtiesList (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getSpecialtiesList();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setSpecialtiesList(tempList);
        }
    }
    private void unloadTransporterCategories (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getTransporterCategories();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setTransporterCategories(tempList);
        }
    }
    private void unloadTransportableTagset (XSSFSheet sheet){
        int rows = sheet.getLastRowNum();
        int unit_id;
        String value;
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            unit_id = (int) row.getCell(0).getNumericCellValue();
            unit_id -= 1;
            value = row.getCell(1).getStringCellValue();
            ArrayList<String> tempList =  uniteDescList.get(unit_id).getTransportableTagSet();
            if (tempList == null){
                tempList = new ArrayList<>();
            }
            tempList.add(value);
            uniteDescList.get(unit_id).setTransportableTagSet(tempList);
        }
    }
}

package org.TalCoWarPro.Requesters.UniteDescriptorRequest;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;

import java.sql.*;
import java.util.ArrayList;

public class UniteDescriptorRequest {

    // Connection parameters
    String url = "jdbc:mariadb://localhost:3306/WarPro";
    String username;
    String password;
    ArrayList<UniteDescriptor> uniteDescList;

    public UniteDescriptorRequest(String username, String password){
        this.username = username;
        this.password = password;
    }


    // Connect to database
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ArrayList<UniteDescriptor> readUniteDescriptor(){
        String retrieveSize = "SELECT COUNT(*) FROM uniteDescriptor";
        String retrieveUniteDesc = "SELECT * FROM uniteDescriptor";

        String retrieveInitialFlagSet = "SELECT * FROM unit_initial_flagset WHERE unit_id = ?";
        String retrieveSizeInitialFlagSet = "SELECT COUNT(*) FROM unit_initial_flagset WHERE unit_id = ?";
        String retrieveTtagsModuleDescriptor = "SELECT * FROM unit_ttags_module_descriptor WHERE unit_id = ?";
        String retrieveSizeTtagsModuleDescriptor = "SELECT COUNT(*) FROM unit_ttags_module_descriptor WHERE unit_id = ?";
        String retrieveSearchedTagsInEngagementTarget = "SELECT * FROM unit_searched_tags_in_engagement_target WHERE unit_id = ?";
        String retrieveSizeSearchedTagsInEngagementTarget = "SELECT COUNT(*) FROM unit_searched_tags_in_engagement_target WHERE unit_id = ?";
        String retrieveIdentifiedTextureValues = "SELECT * FROM unit_identified_texture_values WHERE unit_id = ?";
        String retrieveSizeIdentifiedTextureValues = "SELECT COUNT(*) FROM unit_identified_texture_values WHERE unit_id = ?";
        String retrieveUnidentifiedTextureValues = "SELECT * FROM unit_unidentified_texture_texture_values WHERE unit_id = ?";
        String retrieveSizeUnidentifiedTextureValues = "SELECT COUNT(*) FROM unit_unidentified_texture_texture_values WHERE unit_id = ?";
        String retrieveSpecialtiesList = "SELECT * FROM unit_specialties_list WHERE unit_id = ?";
        String retrieveSizeSpecialtiesList = "SELECT COUNT(*) FROM unit_specialties_list WHERE unit_id = ?";
        String retrieveTransporterCategories = "SELECT * FROM unit_transporter_categories WHERE unit_id = ?";
        String retrieveSizeTransporterCategories = "SELECT COUNT(*) FROM unit_transporter_categories WHERE unit_id = ?";
        String retrieveTransportableTagSet = "SELECT * FROM unit_transportable_tag_set WHERE unit_id = ?";
        String retrieveSizeTransportableTagSet = "SELECT COUNT(*) FROM unit_transportable_tag_set WHERE unit_id = ?";

        uniteDescList = new ArrayList<>();

        try (
                Connection conn = connect();
        ){
            // Variables to retrieve
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
            ArrayList<String> tTagsModuleDescriptor;
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
            ArrayList<String> searchedTagsInEngagementTarget; // TODO: MAKE THIS ITS OWN TABLE (low priority)

            long numOfUniteDesc = 0;

            try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(retrieveSize)) {
                rs.next();
                numOfUniteDesc = (long) rs.getObject(1);
            }catch(SQLException sqe){
                System.out.println(sqe.getMessage());
            }

            try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(retrieveUniteDesc)){
                for (int i = 0; i < numOfUniteDesc; i++) {
                    rs.next();
                    referenceId = (int) rs.getObject(1);
                    descriptor = rs.getString(2);
                    nationalite = rs.getString(3);
                    motherCountry = rs.getString(4);
                    acknowUnitType = rs.getString(5);
                    typeUnitFormation = rs.getString(6);
                    useFollowCam = (Boolean) rs.getObject(7);
                    stickToGround = (Boolean) rs.getObject(8);
                    inGeoDb = (Boolean) rs.getObject(9);
                    porteurMustBeVisible = (Boolean) rs.getObject(10);
                    clampInWorld = (Boolean) rs.getObject(11);
                    clampOutMap = (Boolean) rs.getObject(12);
                    relativeScanningPosition = rs.getString(13);
                    lowAltitudeFlyingAltitude = rs.getString(14);
                    nearGroundFlyingAltitude = rs.getString(15);
                    experienceLevelsPackDescriptor = rs.getString(16);
                    canWinExperience = (Boolean) rs.getObject(17);
                    experienceGainBySecond = rs.getString(18);
                    experienceMultiplierBonusOnKill = rs.getString(19);


                    autoRevealType = rs.getString(20);
                    unitConcealmentBonus = rs.getString(21);
                    visionUnitType = rs.getString(22);
                    unitIsStealth = (Boolean) rs.getObject(23);
                    hideFromDebug = (Boolean) rs.getObject(24);
                    pickableObject = (Boolean) rs.getObject(25);
                    depiction = rs.getString(26);
                    ghostDepiction = rs.getString(27);
                    blackHoleIdentifier = rs.getString(28);
                    gameplayBBoxBoneName = rs.getString(29);
                    autoCoverRange = rs.getString(30);
                    occupationRadius = rs.getString(31);
                    terrainListMask = rs.getString(32);
                    terrainList = rs.getString(33);
                    useTerrainsForEscape = (Boolean) rs.getObject(34);
                    weaponManagerDefault = rs.getString(35);
                    weaponManagerSelection = rs.getString(36);
                    suppressDamagesRegenRatio = rs.getString(37);
                    suppressDamagesRegenRatioOutOfRange = rs.getString(38);
                    stunDamagesRegen = rs.getString(39);
                    stunFreezesUnits = (Boolean) rs.getObject(40);

                    blindageProperties = rs.getString(41);
                    armorDescriptorFront = rs.getString(42);
                    armorDescriptorSides = rs.getString(43);
                    armorDescriptorRear = rs.getString(44);
                    armorDescriptorTop = rs.getString(45);
                    maxSuppressionDamages = rs.getString(46);
                    maxStunDamages = rs.getString(47);
                    maxDamages = rs.getString(48);
                    killWhenDamagesReachMax = (Boolean) rs.getObject(49);
                    hitRollSize = rs.getString(50);
                    hitRollECM = rs.getString(51);
                    autoOrientation = (Boolean) rs.getObject(52);
                    skipCadavreCreation = (Boolean) rs.getObject(53);
                    useTopArmorAgainstFire = (Boolean) rs.getObject(54);
                    physicalDamageLevelsPack = rs.getString(55);
                    suppressDamageLevelsPack = rs.getString(56);
                    stunDamageLevelsPack = rs.getString(57);
                    dangerousness = rs.getString(58);
                    moralLevel = rs.getString(59);

                    maxSpeed = rs.getString(60);
                    unitMovingType = rs.getString(61);
                    pathfindType = rs.getString(62);
                    preferredLayerMask = rs.getString(63);
                    vitesseCombat = rs.getString(64);
                    speedBonusOnRoad = rs.getString(65);
                    maxAcceleration = rs.getString(66);
                    maxDeceleration = rs.getString(67);
                    tempsDemiTour = rs.getString(68);
                    vehicleSubType = rs.getString(69);
                    startTime = rs.getString(70);
                    stopTime = rs.getString(71);
                    rotationStartTime = rs.getString(72);
                    rotationStopTime = rs.getString(73);
                    fuelCapacity = rs.getString(74);
                    fuelMoveDuration = rs.getString(75);
                    opticsAltitudeConfig = rs.getString(76);
                    doesNotCountInScannerAbsoluteMaxRange = (Boolean) rs.getObject(77);
                    porteeVisionTBA = rs.getString(78);
                    porteeVisionFOW = rs.getString(79);
                    detectionTBA = rs.getString(80);

                    porteeVision = rs.getString(81);
                    porteeIdentification = rs.getString(82);
                    opticalStrength = rs.getString(83);
                    opticalStrengthAltitude = rs.getString(84);
                    unitDetectStealthUnit = (Boolean) rs.getObject(85);
                    specializedDetections = rs.getString(86);
                    specializedOpticalStrengths = rs.getString(87);
                    ignoreObstacles = rs.getString(88);
                    identifyBaseProbability = rs.getString(89);
                    timeBetweenEachIdentifyRoll = rs.getString(90);
                    visibilityRuleDescriptor = rs.getString(91);
                    distanceMultiplierRule = rs.getString(92);
                    multiplicateurAPorteeMaximale = rs.getString(93);
                    multiplicateurAPorteeMinimale = rs.getString(94);
                    exposant = rs.getString(95);
                    multiplicateurAPorteeMaximaleEnMouvement = rs.getString(96);
                    multiplicateurAPorteeMinimaleEnMouvement = rs.getString(97);
                    exposantEnMouvement = rs.getString(98);
                    isTransport = (Boolean) rs.getObject(99);
                    transportedTexture = rs.getString(100);

                    transportedSoldier = rs.getString(101);
                    timeToLoad = rs.getString(102);
                    nbSeatsOccupied = rs.getString(103);
                    isTowable = (Boolean) rs.getObject(104);
                    nbSeatsAvailable = rs.getString(105);
                    wreckUnloadPhysicalDamageBonus = rs.getString(106);
                    wreckUnloadSuppressDamageBonus = rs.getString(107);
                    wreckUnloadStunDamageBonus = rs.getString(108);
                    loadRadius = rs.getString(109);
                    factory = rs.getString(110);
                    productionTime = rs.getString(111);
                    commandPoints = rs.getString(112);
                    resourceTickets = rs.getString(113);
                    canAssist = (Boolean) rs.getObject(114);
                    assistRequestBroadcastRadius = rs.getString(115);
                    distanceToFlee = rs.getString(116);
                    maxDistanceForOffensiveReaction = rs.getString(117);
                    maxDistanceForOffensiveReactionOnFlyingTarget = rs.getString(118);
                    maxDistanceForEngagement = rs.getString(119);
                    minimapDisplayTexture = rs.getString(120);
                    minimapDisplayGhostTexture = rs.getString(121);
                    minimapDisplayIsAlwaysVisible = (Boolean) rs.getObject(122);
                    minimapDisplayUseTeamColor = (Boolean) rs.getObject(123);
                    minimapDisplayFollowUnitOrientation = (Boolean) rs.getObject(124);
                    validOrders = rs.getString(125);
                    unlockableOrders = rs.getString(126);
                    multiSelectionSortingOrder = rs.getString(127);
                    unitName = rs.getString(128);
                    identifiedTexture = rs.getString(129);
                    identifiedTextureCommandNameTrigger = rs.getString(130);
                    identifiedTextureAlterator = rs.getString(131);
                    defaultSpeciailtyToken = rs.getString(132);
                    unidentifiedTexture = rs.getString(133);
                    unidentifiedTextureCommandNameTrigger = rs.getString(134);
                    unidentifiedTextureAlterator = rs.getString(135);
                    positionHeightOffset = rs.getString(136);
                    nbSoldiers = rs.getString(137);
                    evacuationTime = rs.getString(138);
                    travelDuration = rs.getString(139);
                    unitAttackValue = rs.getString(140);
                    unitDefenseValue = rs.getString(141);
                    unitBonusXpPerLevelValue = rs.getString(142);
                    unitRole = rs.getString(143);
                    nameToken = rs.getString(144);
                    infoPanelConfigurationToken = rs.getString(145);
                    typeSpecificToken = rs.getString(146);
                    realRoadSpeed = rs.getString(147);
                    isAce = (Boolean) rs.getObject(148);
                    upgradeFromUnit = rs.getString(149);
                    generateName = (Boolean) rs.getObject(150);
                    menuIconTexture = rs.getString(151);
                    buttonTexture = rs.getString(152);
                    countryTexture = rs.getString(153);
                    typeStrategicCount = rs.getString(154);

                    UniteDescriptor uniteDesc = new UniteDescriptor(referenceId, descriptor, nationalite, motherCountry, acknowUnitType, typeUnitFormation,
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
                }

            }

            // InitialFlagSet List
            try{
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeInitialFlagSet);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveInitialFlagSet);
                int id = 0;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read InitialFlagSet");
                System.out.println(e.getMessage());
            }

            // TtagsModuleDesc
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeTtagsModuleDescriptor);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveTtagsModuleDescriptor);
                int id = 1;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read TtagsModuleDesc");
                System.out.println(e.getMessage());
            }

            // SearchedTagsInEngagementRange
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeSearchedTagsInEngagementTarget);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveSearchedTagsInEngagementTarget);
                int id = 2;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read SearchedTagsInEngagementRange");
                System.out.println(e.getMessage());
            }

            // IdentifiedTextureValues
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeIdentifiedTextureValues);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveIdentifiedTextureValues);
                int id = 3;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read IdentifiedTextureValues");
                System.out.println(e.getMessage());
            }

            // UnidentifiedTextureValues
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeUnidentifiedTextureValues);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveUnidentifiedTextureValues);
                int id = 4;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read UnidentifiedTextureValues");
                System.out.println(e.getMessage());
            }

            // SpecialtiesList
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeSpecialtiesList);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveSpecialtiesList);
                int id = 4;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read SpecialtiesList");
                System.out.println(e.getMessage());
            }

            // TransporterCategories
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeTransporterCategories);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveTransporterCategories);
                int id = 5;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read TransporterCategories");
                System.out.println(e.getMessage());
            }

            // TransportableTagSet
            try {
                PreparedStatement stmt1 = conn.prepareStatement(retrieveSizeTransportableTagSet);
                PreparedStatement stmt2 = conn.prepareStatement(retrieveTransportableTagSet);
                int id = 6;
                readLinkedTable(stmt1, stmt2, id);
            }catch (Exception e){
                System.out.println("ERORR: Cannot read TransportableTagSet");
                System.out.println(e.getMessage());
            }



        }catch (SQLException sqe){
            System.out.println(sqe.getMessage());
        }
        return (uniteDescList);

    }

    private void readLinkedTable (PreparedStatement stmt1, PreparedStatement stmt2, int arrayName) throws SQLException {
        long numOfTables = 0;
        int unitId = 0;
        String retrievedValue;

        for (int i = 1; i < uniteDescList.size(); i++) {
            ArrayList<String> tempList = new ArrayList<>();
            stmt1.setInt(1, i);
            try (ResultSet rs = stmt1.executeQuery()) {
                rs.next();
                numOfTables = (long) rs.getObject(1);
            } catch (SQLException sqe) {
                System.out.println(sqe.getMessage());
            }
            stmt2.setInt(1, i);
            try(ResultSet rs = stmt2.executeQuery()) {
                for (int x = 0; x < numOfTables; x++) {
                    rs.next();
                    unitId = rs.getInt (1);
                    retrievedValue = rs.getString(2);
                    tempList.add(retrievedValue);
                }
                switch (arrayName) {
                    case 0 -> uniteDescList.get(unitId).setInitialFlagSet(tempList);
                    case 1 -> uniteDescList.get(unitId).setTTagsModuleDescriptor(tempList);
                    case 2 -> uniteDescList.get(unitId).setSearchedTagsInEngagementTarget(tempList);
                    case 3 -> uniteDescList.get(unitId).setIdentifiedTextureValues(tempList);
                    case 4 -> uniteDescList.get(unitId).setUnidentifiedTextureTextureValues(tempList);
                    case 5 -> uniteDescList.get(unitId).setSpecialtiesList(tempList);
                    case 6 -> uniteDescList.get(unitId).setTransporterCategories(tempList);
                    case 7 -> uniteDescList.get(unitId).setTransportableTagSet(tempList);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}

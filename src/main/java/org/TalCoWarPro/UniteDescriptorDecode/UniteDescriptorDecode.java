package org.TalCoWarPro.UniteDescriptorDecode;

import org.TalCoWarPro.Objects.UniteDescriptor.UniteDescriptor;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.DriverManager;
import java.util.ArrayList;


public class UniteDescriptorDecode {
    BufferedReader reader;
    String line;
    ArrayList<UniteDescriptor> uniteDescriptorList = new ArrayList<>();

    public ArrayList<UniteDescriptor> uniteDescriptorDecode() throws IOException {

        // Sorry but this is the best way I could think of to do this :(
        // Hello and welcome to this mess of code, please buckle your seatbelt.#

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("UniteDescriptor.ndf")));
        }catch (Exception e) {
            System.out.println("Sorry, the application cannot find UniteDescriptor.ndf Please ensure it is in the same director as this jar file");
        }

        // While loop to read through entire file


        // Skip the first 3 lines (they're empty)
        for (int i = 0; i < 3; i++){
            line = reader.readLine();
        }

        while ((line = reader.readLine())!= null){

            // Start of export block
            if (line.startsWith("export")){
                // Read the descriptor
                String descriptor = line.substring(7, line.indexOf("is TEntityDescriptor") - 1);
                // Good luck reading this, sorry...

                // Unit nationality
                String nationalite = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("Nationalite")){
                        nationalite = line.substring(47);
                        break;
                    }
                    line = reader.readLine();
                }

                // Unit country
                String motherCountry = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("MotherCountry")){
                        motherCountry = line.substring(48, line.lastIndexOf("'"));
                        break;
                    }
                    line = reader.readLine();
                }

                // Acknow unit type
                String acknowUnitType = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("AcknowUnitType")){
                        acknowUnitType = line.substring(47);
                        break;
                    }
                    line = reader.readLine();
                }

                // TypeUnitFormation
                String typeUnitFormation = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("TypeUnitFormation")){
                        typeUnitFormation = line.substring(48, line.lastIndexOf("'"));
                        break;
                    }
                    line = reader.readLine();
                }

                // InitialFlagSet
                ArrayList<String> initialFlagSet = new ArrayList<>();
                while (!(line.startsWith(")"))){
                    if (line.contains("InitialFlagSet")){
                        reader.readLine(); // Move to next line
                        line = reader.readLine(); // Skip opening bracket
                        while (!(line.contains("]"))) {
                            initialFlagSet.add(line.substring(16, line.lastIndexOf(",")));
                            line = reader.readLine(); // Move to next line
                        }
                        break;
                    }
                    line = reader.readLine();
                }

                // UseFollowCam
                Boolean useFollowCam = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("UseFollowCam")){
                        useFollowCam = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // StickToGround
                Boolean stickToGround = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("StickToGround")){
                        stickToGround = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // InGeoDb
                Boolean inGeoDb = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("InGeoDb")){
                        inGeoDb = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // PorteurMustBeVisible
                Boolean porteurMustBeVisible = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("PorteurMustBeVisible")){
                        porteurMustBeVisible = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // ClampInWorld
                Boolean clampInWorld = null;
                 while (!(line.startsWith(")"))){
                    if (line.contains("ClampInWorld")){
                        clampInWorld = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // ClampOutMap
                Boolean clampOutMap = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("ClampOutMap")){
                        clampOutMap = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // RelativeScanningPosition
                String relativeScanningPosition = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("RelativeScanningPosition")){
                        relativeScanningPosition = line.substring(45);
                        break;
                    }
                    line = reader.readLine();
                }

                // LowAltitudeFlyingAltitude
                String lowAltitudeFlyingAltitude = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("LowAltitudeFlyingAltitude")){
                        lowAltitudeFlyingAltitude = line.substring(46, line.length() -1);
                        break;
                    }
                    line = reader.readLine();
                }

                // NearGroundFlyingAltitude
                String nearGroundFlyingAltitude = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("NearGroundFlyingAltitude")){
                        nearGroundFlyingAltitude = line.substring(46, line.length() -1);
                        break;
                    }
                    line = reader.readLine();
                }

                // TTagsModuleDescriptor
                ArrayList<String> tTagsModuleDescriptor = new ArrayList<>();
                while (!(line.startsWith(")"))){
                    if (line.contains("TTagsModuleDescriptor")){
                        reader.readLine(); // Move to next line
                        reader.readLine(); // Skip TagSet = [
                        line = reader.readLine(); // First line of tags
                        while (!(line.contains("]"))) {
                            tTagsModuleDescriptor.add(line.substring(17, line.lastIndexOf(",")-1));
                            line = reader.readLine(); // Move to next line
                        }
                        break;
                    }
                    line = reader.readLine();
                }

                // ExperienceLevelsPackDescriptor
                String experienceLevelsPackDescriptor = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("ExperienceLevelsPackDescriptor")){
                        experienceLevelsPackDescriptor = line.substring(45);
                        break;
                    }
                    line = reader.readLine();
                }

                // experienceLevelsPackDescriptor
                Boolean canWinExperience = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("CanWinExperience")){
                        canWinExperience = Boolean.valueOf(line.substring(31));
                        break;
                    }
                    line = reader.readLine();
                }

                // ExperienceGainBySecond
                String experienceGainBySecond = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("ExperienceGainBySecond")){
                        experienceGainBySecond = line.substring(37);
                        break;
                    }
                    line = reader.readLine();
                }

                // Declare variables
                String experienceMultiplierBonusOnKill = null;
                String autoRevealType = null;
                String unitConcealmentBonus = null;
                 String visionUnitType = null;
                Boolean unitIsStealth = null;
                Boolean hideFromDebug = null;
                Boolean pickableObject = null;
                String depiction = null;
                String ghostDepiction = null;
                String blackHoleIdentifier = null;
                String gameplayBBoxBoneName = null;


                // ExperienceMultiplierBonusOnKill

                while (!(line.startsWith(")"))){
                    if (line.contains("ExperienceMultiplierBonusOnKill")){
                        experienceMultiplierBonusOnKill = line.substring(46);
                        break;
                    }
                    line = reader.readLine();
                }

                // AutoRevealType
                while (!(line.startsWith(")"))){
                    if (line.contains("AutoRevealType")){
                        autoRevealType = line.substring(35);
                        break;
                    }
                    line = reader.readLine();
                }

                // UnitConcealmentBonus
                while (!(line.startsWith(")"))){
                    if (line.contains("UnitConcealmentBonus")){
                        unitConcealmentBonus = line.substring(35);
                        break;
                    }
                    line = reader.readLine();
                }

                // VisionUnitType
                while (!(line.startsWith(")"))){
                    if (line.contains("VisionUnitType")){
                        visionUnitType = line.substring(35);
                        break;
                    }
                    line = reader.readLine();
                }

                // UnitIsStealth
                while (!(line.startsWith(")"))){
                    if (line.contains("UnitIsStealth")){
                        unitIsStealth = Boolean.valueOf(line.substring(35));
                        break;
                    }
                    line = reader.readLine();
                }

                // HideFromDebug
                while (!(line.startsWith(")"))){
                    if (line.contains("HideFromDebug")){
                        hideFromDebug = Boolean.valueOf(line.substring(35));
                        break;
                    }
                    line = reader.readLine();
                }

                // Handling for units with longer + shorter versions of TApparenceModelModuleDescriptor
                Integer pointer = 39;
                Boolean shortened = true;
                while (!(line.contains("TModuleSelector"))) {
                    while (!(line.startsWith(")"))) {
                        if (line.contains("Default")) {
                            pointer = 57;
                            shortened = false;
                            break;
                        }else if (line.contains("PickableObject")){
                            break;
                        }
                        line = reader.readLine();
                    }

                    // PickableObject
                    while (!(line.startsWith(")"))) {
                        if (line.contains("PickableObject")) {
                            pickableObject = Boolean.valueOf(line.substring(pointer));
                            break;
                        }
                        line = reader.readLine();
                    }

                    // Depiction
                    while (!(line.startsWith(")"))) {
                        if (line.contains("Depiction")) {
                            depiction = line.substring(pointer);
                            break;
                        }
                        line = reader.readLine();
                    }

                    if (!shortened) {

                        // GhostDepiction
                        while (!(line.startsWith(")"))) {
                            if (line.contains("GhostDepiction")) {
                                ghostDepiction = line.substring(pointer);
                                break;
                            }
                            line = reader.readLine();
                        }

                        // BlackHoleIdentifier
                        while (!(line.startsWith(")"))) {
                            if (line.contains("BlackHoleIdentifier")) {
                                blackHoleIdentifier = line.substring(pointer+1, line.length() - 1);
                                break;
                            }
                            line = reader.readLine();
                        }

                        // GameplayBBoxBoneName
                        while (!(line.startsWith(")"))) {
                            if (line.contains("GameplayBBoxBoneName")) {
                                gameplayBBoxBoneName = line.substring(pointer+1, line.length() - 1);
                                break;
                            }
                            line = reader.readLine();
                        }
                        break;
                    } else{
                        line = reader.readLine();
                        line = reader.readLine();
                    }
                }

                // Cycle through unneccessary lines
                for (int i = 0; i < 4; i++){
                    line = reader.readLine();
                }

                boolean flagAircraft = line.contains("WeaponManager");
                String autoCoverRange = null;
                String occupationRadius = null;
                String terrainListMask = null;
                String terrainList = null;
                Boolean useTerrainsForEscape = null;

                // Handling for aircraft
                if (!flagAircraft) {
                    // AutoCoverRange
                    while (!(line.startsWith(")"))) {
                        if (line.contains("AutoCoverRange")) {
                            autoCoverRange = line.substring(49);
                            break;
                        } else if (line.contains("TDamageModuleDescriptor")) {// Only way to filter out helicopters at this stage
                            flagAircraft = true;
                            break;
                        }
                            line = reader.readLine();
                    }
                }
                if (!flagAircraft){

                    // OccupationRadius
                    while (!(line.startsWith(")"))) {
                        if (line.contains("OccupationRadius")) {
                            occupationRadius = line.substring(49);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // TerrainListMask
                    while (!(line.startsWith(")"))) {
                        if (line.contains("TerrainListMask")) {
                            terrainListMask = line.substring(49);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // TerrainList
                    while (!(line.startsWith(")"))) {
                        if (line.contains("TerrainList                =")) {
                            terrainList = line.substring(49);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // UseTerrainsForEscape
                    while (!(line.startsWith(")"))) {
                        if (line.contains("UseTerrainsForEscape")) {
                            useTerrainsForEscape = Boolean.valueOf(line.substring(49));
                            break;
                        }
                        line = reader.readLine();
                    }
                }

                String weaponManagerDefault = null;
                String weaponManagerSelection = null;
                String suppressDamagesRegenRatio = null;
                String suppressDamagesRegenRatioOutOfRange = null;
                String stunDamagesRegen = null;
                Boolean stunFreezesUnits = null;
                String blindageProperties = null;
                String armorDescriptorFront = null;
                String armorDescriptorSides = null;
                String armorDescriptorRear = null;
                String armorDescriptorTop = null;
                String maxSuppressionDamages = null;
                String maxStunDamages = null;
                String maxDamages = null;
                Boolean killWhenDamagesReachMax = null;
                String hitRollSize = null;
                String hitRollECM = null;
                Boolean autoOrientation = null;
                Boolean skipCadavreCreation = null;
                Boolean useTopArmorAgainstFire = null;
                String physicalDamageLevelsPack = null;
                String suppressDamageLevelsPack = null;
                String stunDamageLevelsPack = null;
                String dangerousness = null;
                String moralLevel = null;
                String maxSpeed = null;


                boolean flagWeapon = false;
                while (!(line.startsWith(")"))){
                    if (line.contains("WeaponManager")){
                        flagWeapon = true;
                        break;
                    }else if (line.contains("TDamageModuleDescriptor")){
                        break;
                    }else{
                        line = reader.readLine();
                    }
                }

                if (flagWeapon) {
                    // WeaponManager Default
                    while (!(line.startsWith(")"))) {
                        if (line.contains("Default")) {
                            weaponManagerDefault = line.substring(29);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // WeaponManager Selection
                    while (!(line.startsWith(")"))) {
                        if (line.contains("Selection")) {
                            weaponManagerSelection = line.substring(30, line.length() - 1);
                            break;
                        }
                        line = reader.readLine();
                    }
                }
                // SuppressDamagesRegenRatio
                while (!(line.startsWith(")"))){
                    if (line.contains("SuppressDamagesRegenRatio")){
                        suppressDamagesRegenRatio = line.substring(52);
                        break;
                    }
                    line = reader.readLine();
                }

                // SuppressDamagesRegenRatioOutOfRange
                while (!(line.startsWith(")"))){
                    if (line.contains("SuppressDamagesRegenRatioOutOfRange")){
                        suppressDamagesRegenRatioOutOfRange = line.substring(62);
                        break;
                    }
                    line = reader.readLine();
                }

                // StunDamagesRegen
                while (!(line.startsWith(")"))){
                    if (line.contains("StunDamagesRegen")){
                        stunDamagesRegen = line.substring(43);
                        break;
                    }
                    line = reader.readLine();
                }

                // StunFreezesUnits
                while (!(line.startsWith(")"))){
                    if (line.contains("StunFreezesUnits")){
                        stunFreezesUnits = Boolean.valueOf(line.substring(43));
                        break;
                    }
                    line = reader.readLine();
                }

                // BlindageProperties
                while (!(line.startsWith(")"))){
                    if (line.contains("BlindageProperties")){
                        blindageProperties = line.substring(45);
                        break;
                    }
                    line = reader.readLine();
                }

                // ArmorDescriptorFront
                while (!(line.startsWith(")"))){
                    if (line.contains("ArmorDescriptorFront")){
                        armorDescriptorFront = line.substring(51);
                        break;
                    }
                    line = reader.readLine();
                }

                // ArmorDescriptorSides
                while (!(line.startsWith(")"))){
                    if (line.contains("ArmorDescriptorSides")){
                        armorDescriptorSides = line.substring(51);
                        break;
                    }
                    line = reader.readLine();
                }

                // ArmorDescriptorRear
                while (!(line.startsWith(")"))){
                    if (line.contains("ArmorDescriptorRear")){
                        armorDescriptorRear = line.substring(50);
                        break;
                    }
                    line = reader.readLine();
                }

                // ArmorDescriptorTop
                while (!(line.startsWith(")"))){
                    if (line.contains("ArmorDescriptorTop")){
                        armorDescriptorTop = line.substring(49);
                        break;
                    }
                    line = reader.readLine();
                }

                // MaxSuppressionDamages
                while (!(line.startsWith(")"))){
                    if (line.contains("MaxSuppressionDamages")){
                        maxSuppressionDamages = line.substring(48);
                        break;
                    }
                    line = reader.readLine();
                }

                // MaxStunDamages
                while (!(line.startsWith(")"))){
                    if (line.contains("MaxStunDamages")){
                        maxStunDamages = line.substring(41);
                        break;
                    }
                    line = reader.readLine();
                }

                // MaxDamages
                while (!(line.startsWith(")"))){
                    if (line.contains("MaxDamages")){
                        maxDamages = line.substring(33);
                        break;
                    }
                    line = reader.readLine();
                }

                // KillWhenDamagesReachMax
                while (!(line.startsWith(")"))){
                    if (line.contains("KillWhenDamagesReachMax")){
                        killWhenDamagesReachMax = Boolean.valueOf(line.substring(46));
                        break;
                    }
                    line = reader.readLine();
                }

                // HitRollSize
                while (!(line.startsWith(")"))){
                    if (line.contains("HitRollSize")){
                        hitRollSize = line.substring(34);
                        break;
                    }
                    line = reader.readLine();
                }

                // HitRollECM
                while (!(line.startsWith(")"))){
                    if (line.contains("HitRollECM")){
                        hitRollECM = line.substring(33);
                        break;
                    }
                    line = reader.readLine();
                }

                // AutoOrientation
                while (!(line.startsWith(")"))){
                    if (line.contains("AutoOrientation")){
                        autoOrientation = Boolean.valueOf(line.substring(38));
                        break;
                    }
                    line = reader.readLine();
                }

                // SkipCadavreCreation
                while (!(line.startsWith(")"))){
                    if (line.contains("SkipCadavreCreation")){
                        skipCadavreCreation = Boolean.valueOf(line.substring(43));
                        break;
                    }
                    line = reader.readLine();
                }

                // UseTopArmorAgainstFire
                while (!(line.startsWith(")"))){
                    if (line.contains("UseTopArmorAgainstFire")){
                        useTopArmorAgainstFire = Boolean.valueOf(line.substring(45));
                        break;
                    }
                    line = reader.readLine();
                }

                // PhysicalDamageLevelsPack
                while (!(line.startsWith(")"))){
                    if (line.contains("PhysicalDamageLevelsPack")){
                        physicalDamageLevelsPack = line.substring(47);
                        break;
                    }
                    line = reader.readLine();
                }

                // SuppressDamageLevelsPack
                while (!(line.startsWith(")"))){
                    if (line.contains("SuppressDamageLevelsPack")){
                        suppressDamageLevelsPack = line.substring(47);
                        break;
                    }
                    line = reader.readLine();
                }

                // StunDamageLevelsPack
                while (!(line.startsWith(")"))){
                    if (line.contains("StunDamageLevelsPack")){
                        stunDamageLevelsPack = line.substring(43);
                        break;
                    }
                    line = reader.readLine();
                }

                boolean flagDangerousness = false;
                while (!(line.startsWith(")"))){
                    if (line.contains("TDangerousnessModuleDescriptor")){
                        flagDangerousness = true;
                        break;
                    }else if (line.contains("TModuleSelector")){
                        break;
                    }else{
                        line = reader.readLine();
                    }
                }

                if (flagDangerousness) {
                    // Dangerousness
                    while (!(line.startsWith(")"))) {
                        if (line.contains("Dangerousness  = ")) {
                            dangerousness = line.substring(34);
                            break;
                        }
                        line = reader.readLine();
                    }
                }

                // MoralLevel
                while (!(line.startsWith(")"))){
                    if (line.contains("MoralLevel")){
                        moralLevel = line.substring(21);
                        break;
                    }
                    line = reader.readLine();
                }

                // MaxSpeed
                while (!(line.startsWith(")"))){
                    if (line.contains("MaxSpeed")){
                        maxSpeed = line.substring(34);
                        break;
                    }
                    line = reader.readLine();
                }


                String unitMovingType = null;
                String pathfindType = null;
                String preferredLayerMask = null;
                String vitesseCombat = null;
                String speedBonusOnRoad = null;
                String maxAcceleration = null;
                String maxDeceleration = null;
                String tempsDemiTour = null;
                String vehicleSubType = null;
                String startTime = null;
                String stopTime = null;
                String rotationStartTime = null;
                String rotationStopTime = null;
                if (!flagAircraft){
                    // UnitMovingType
                    while (!(line.startsWith(")"))){
                        if (line.contains("UnitMovingType")){
                            unitMovingType = line.substring(37);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // PathfindType
                    while (!(line.startsWith(")"))){
                        if (line.contains("PathfindType")){
                            pathfindType = line.substring(35);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // PreferredLayerMask
                    while (!(line.startsWith(")"))){
                        if (line.contains("PreferredLayerMask")){
                            preferredLayerMask = line.substring(41);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // VitesseCombat

                    while (!(line.startsWith(")"))){
                        if (line.contains("VitesseCombat")){
                            vitesseCombat = line.substring(37, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // SpeedBonusOnRoad

                    while (!(line.startsWith(")"))){
                        if (line.contains("SpeedBonusOnRoad")){
                            speedBonusOnRoad = line.substring(39);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // MaxAcceleration

                    while (!(line.startsWith(")"))){
                        if (line.contains("MaxAcceleration")){
                            maxAcceleration = line.substring(39, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // MaxDeceleration

                    while (!(line.startsWith(")"))){
                        if (line.contains("MaxDeceleration")){
                            maxDeceleration = line.substring(39, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // TempsDemiTour

                    while (!(line.startsWith(")"))){
                        if (line.contains("TempsDemiTour")){
                            tempsDemiTour = line.substring(36);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // VehicleSubType

                    while (!(line.startsWith(")"))){
                        if (line.contains("VehicleSubType")){
                            vehicleSubType = line.substring(37);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // StartTime

                    while (!(line.startsWith(")"))){
                        if (line.contains("StartTime")){
                            startTime = line.substring(33, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // StopTime

                    while (!(line.startsWith(")"))){
                        if (line.contains("StopTime")){
                            stopTime = line.substring(32, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // RotationStartTime

                    while (!(line.startsWith(")"))){
                        if (line.contains("RotationStartTime")){
                            rotationStartTime = line.substring(41, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // RotationStopTime
                    while (!(line.startsWith(")"))){
                        if (line.contains("RotationStopTime")){
                            rotationStopTime = line.substring(40, line.length() -1);
                            break;
                        }
                        line = reader.readLine();
                    }
                }else{
                    // TODO: ADD
                    //                MaxSpeed         = 560 * Metre
                    //                WorldFloorProxy  = $/M3D/Scene/WorldFloorForHelicoProxy
                    //                MaxAcceleration  = 80 * Metre
                    //                MaxDeceleration  = 80 * Metre
                    //                TempsDemiTour    = 2
                    //                UpwardSpeed      = 100 * Metre
                    //                TorqueManoeuvrability = 110
                    //                CyclicManoeuvrability = 130
                    //                MaxInclination   = 89
                    //                GFactorLimit     = 3.5
                    //                RotorArea        = 140
                    //                Mass             = 4300
                }

                Boolean flagInfantry = null;
                while (flagInfantry == null){
                    line = reader.readLine();
                    if (line.contains("TFuelModuleDescriptor")){
                        flagInfantry = false;
                    }else if (line.contains("TScannerConfigurationDescriptor")){
                        flagInfantry = true;
                    }
                }

                String fuelCapacity = null;
                String fuelMoveDuration = null;

                if (!flagInfantry) {
                    // FuelCapacity
                    while (!(line.startsWith(")"))) {
                        if (line.contains("FuelCapacity")) {
                            fuelCapacity = line.substring(39);
                            break;
                        }
                        line = reader.readLine();
                    }

                    // FuelMoveDuration
                    while (!(line.startsWith(")"))) {
                        if (line.contains("FuelMoveDuration")) {
                            fuelMoveDuration = line.substring(39);
                            break;
                        }
                        line = reader.readLine();
                    }
                }

                // OpticsAltitudeConfig
                String opticsAltitudeConfig = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("OpticsAltitudeConfig")){
                        opticsAltitudeConfig = line.substring(43);
                        break;
                    }
                    line = reader.readLine();
                }

                // DoesNotCountInScannerAbsoluteMaxRange
                Boolean doesNotCountInScannerAbsoluteMaxRange = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("DoesNotCountInScannerAbsoluteMaxRange")){
                        doesNotCountInScannerAbsoluteMaxRange = Boolean.valueOf(line.substring(60));
                        break;
                    }
                    line = reader.readLine();
                }

                // PorteeVisionTBA
                String porteeVisionTBA = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("PorteeVisionTBA")){
                        porteeVisionTBA = line.substring(39, line.length() -1);
                        break;
                    }
                    line = reader.readLine();
                }

                // PorteeVisionFOW
                String porteeVisionFOW = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("PorteeVisionFOW")){
                        porteeVisionFOW = line.substring(39, line.length() -1);
                        break;
                    }
                    line = reader.readLine();
                }

                // DetectionTBA
                String detectionTBA = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("DetectionTBA")){
                        detectionTBA = line.substring(36, line.length() -1);
                        break;
                    }
                    line = reader.readLine();
                }

                // PorteeVision
                String porteeVision = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("PorteeVision")){
                        porteeVision = line.substring(36, line.length() -1);
                        break;
                    }
                    line = reader.readLine();
                }

                // PorteeIdentification
                String porteeIdentification = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("PorteeIdentification")){
                        porteeIdentification = line.substring(43);
                        break;
                    }
                    line = reader.readLine();
                }

                // OpticalStrength
                String opticalStrength = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("OpticalStrength")){
                        opticalStrength = line.substring(38);
                        break;
                    }
                    line = reader.readLine();
                }

                // OpticalStrengthAltitude
                String opticalStrengthAltitude = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("OpticalStrengthAltitude")){
                        opticalStrengthAltitude = line.substring(46);
                        break;
                    }
                    line = reader.readLine();
                }

                // UnitDetectStealthUnit
                Boolean unitDetectStealthUnit = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("UnitDetectStealthUnit")){
                        unitDetectStealthUnit = Boolean.valueOf(line.substring(44));
                        break;
                    }
                    line = reader.readLine();
                }

                // SpecializedDetections
                String specializedDetections = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("SpecializedDetections")){
                        if(line.endsWith("[")) {
                            line = reader.readLine();
                            if (!line.contains("]")) {
                                specializedDetections = line.substring(line.indexOf("(") + 2, line.lastIndexOf(")") - 1);
                            }
                        }
                        break;
                    }
                    line = reader.readLine();
                }

                // SpecializedOpticalStrengths
                String specializedOpticalStrengths = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("SpecializedOpticalStrengths")){
                        if(line.endsWith("[")) {
                            line = reader.readLine();
                            if (!line.contains("]")) {
                                specializedOpticalStrengths = line.substring(line.indexOf("(") + 2, line.lastIndexOf(")") - 1);
                            }
                        }
                        break;
                    }
                    line = reader.readLine();
                }

                // IgnoreObstacles
                String ignoreObstacles = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("IgnoreObstacles")){
                        if(line.endsWith("[")) {
                            line = reader.readLine();
                            if (!line.contains("]")) {
                                ignoreObstacles = line.substring(line.indexOf("(") + 2, line.lastIndexOf(")") - 1);
                            }
                        }
                        break;
                    }
                    line = reader.readLine();
                }

                // IdentifyBaseProbability
                String identifyBaseProbability = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("IdentifyBaseProbability")){
                        identifyBaseProbability = line.substring(46);
                        break;
                    }
                    line = reader.readLine();
                }

                // TimeBetweenEachIdentifyRoll
                String timeBetweenEachIdentifyRoll = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("TimeBetweenEachIdentifyRoll")){
                        timeBetweenEachIdentifyRoll = line.substring(46);
                        break;
                    }
                    line = reader.readLine();
                }

                // VisibilityRuleDescriptor
                String visibilityRuleDescriptor = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("VisibilityRuleDescriptor")){
                        visibilityRuleDescriptor = line.substring(46);
                        break;
                    }
                    line = reader.readLine();
                }

                // DistanceMultiplierRule
                String distanceMultiplierRule = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("DistanceMultiplierRule")){
                        distanceMultiplierRule = line.substring(46);
                        break;
                    }
                    line = reader.readLine();
                }

                // MultiplicateurAPorteeMaximale
                String multiplicateurAPorteeMaximale = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("MultiplicateurAPorteeMaximale")){
                        multiplicateurAPorteeMaximale = line.substring(63);
                        break;
                    }
                    line = reader.readLine();
                }

                // MultiplicateurAPorteeMinimale
                String multiplicateurAPorteeMinimale = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("MultiplicateurAPorteeMinimale")){
                        multiplicateurAPorteeMinimale = line.substring(63);
                        break;
                    }
                    line = reader.readLine();
                }

                // Exposant
                String exposant = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("Exposant")){
                        exposant = line.substring(63);
                        break;
                    }
                    line = reader.readLine();
                }
                // MultiplicateurAPorteeMaximaleEnMouvement
                String multiplicateurAPorteeMaximaleEnMouvement = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("MultiplicateurAPorteeMaximaleEnMouvement")){
                        multiplicateurAPorteeMaximaleEnMouvement = line.substring(63);
                        break;
                    }
                    line = reader.readLine();
                }
                // MultiplicateurAPorteeMinimaleEnMouvement
                String multiplicateurAPorteeMinimaleEnMouvement = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("MultiplicateurAPorteeMinimaleEnMouvement")){
                        multiplicateurAPorteeMinimaleEnMouvement = line.substring(63);
                        break;
                    }
                    line = reader.readLine();
                }
                // ExposantEnMouvement
                String exposantEnMouvement = null;
                while (!(line.startsWith(")"))){
                    if (line.contains("ExposantEnMouvement")){
                        exposantEnMouvement = line.substring(63);
                        break;
                    }
                    line = reader.readLine();
                }

                // Transports are gonna be annoying

                // Skip "blank" lines
                for (int i = 0; i < 4; i++){
                    line = reader.readLine();
                }

                Boolean isTransport = false;
                String transportedTexture = null;
                String transportedSoldier = null;
                String nbSeatsOccupied = null;
                String timeToLoad = null;
                Boolean isTowable = null;
                boolean flagTransport = false;

                if (line.contains("TTransportableModuleDescriptor")){
                    isTransport = true;
                    while (!(line.startsWith(")"))){
                        if (line.contains("Categories")){
                            if(line.endsWith("[")) {
                                line = reader.readLine();
                                if (!line.contains("]")) {
                                    String categories = line.substring(line.indexOf("(") + 2, line.lastIndexOf(")") - 1);
                                }
                            }
                            break;
                        }
                        line = reader.readLine();
                    }

                    // TransportedTexture
                    transportedTexture = stringDecode("TransportedTexture", 57, null);
                    // TransportedSoldier
                    transportedSoldier = stringDecode("TransportedSoldier", 58, 1);
                    nbSeatsOccupied = stringDecode("NbSeatsOccupied", 57, null);
                    timeToLoad = stringDecode("TimeToLoad", 57, null);
                    isTowable = booleanDecode("IsTowable", 57, null);
                }

                ArrayList<String> transporterCategories = new ArrayList<String>();
                ArrayList<String> transportableTagSet = new ArrayList<String>();
                String nbSeatsAvailable = null;
                String wreckUnloadPhysicalDamageBonus = null;
                String wreckUnloadSuppressDamageBonus = null;
                String wreckUnloadStunDamageBonus = null;
                String loadRadius = null;

                while (!(line.startsWith(")"))) {
                    if (line.contains("Transporter is")){

                        transporterCategories = blockStringDecode("Categories", 41, 2);
                        transportableTagSet = blockStringDecode("TransportableTagSet", 41, 2);
                        nbSeatsAvailable = stringDecode("NbSeatsAvailable", 52, null);
                        wreckUnloadPhysicalDamageBonus = stringDecode("WreckUnloadPhysicalDamageBonus", 52, null);
                        wreckUnloadSuppressDamageBonus = stringDecode("WreckUnloadSuppressDamageBonus", 52, null);
                        wreckUnloadStunDamageBonus = stringDecode("WreckUnloadStunDamageBonus", 52, null);
                        loadRadius = stringDecode("LoadRadius", 53, 1);

                    }else if (line.contains("TCadavreGeneratorModuleDescriptorUnit")){
                        break;
                    }else{
                        line = reader.readLine();
                    }
                }


                // Default = TProductionModuleDescriptor
                String factory = stringDecode("Factory", 41, null);
                String productionTime = stringDecode("ProductionTime", 41, null);
                String commandPoints = stringDecode("Resource_CommandPoints", 51, 2);
                String resourceTickets = null;
                if((line = reader.readLine()).contains("Resource_Tickets")) {
                    resourceTickets = stringDecode("Resource_Tickets", 45, 2);
                }

                // Default = TAutomaticBehaviorModuleDescriptor
                Boolean canAssist = booleanDecode("CanAssist", 33, null);
                String assistRequestBroadcastRadius = stringDecode("AssistRequestBroadcastRadius", 52, null);
                String distanceToFlee = stringDecode("DistanceToFlee", 38, null);
                String maxDistanceForOffensiveReaction = stringDecode("MaxDistanceForOffensiveReaction", 55, null);
                String maxDistanceForOffensiveReactionOnFlyingTarget = stringDecode("MaxDistanceForOffensiveReactionOnFlyingTarget", 69, null);
                String maxDistanceForEngagement = stringDecode("MaxDistanceForEngagement", 48, null);
                ArrayList<String> searchedTagsInEngagementTarget = blockStringDecode("SearchedTagsInEngagement", 25, 2);

                // TMinimapDisplayModuleDescriptor
                String minimapDisplayTexture = stringDecode("Texture", 27, 1);
                String minimapDisplayGhostTexture = null;
                if (!flagAircraft) {
                    minimapDisplayGhostTexture = stringDecode("GhostTexture", 32, 1);
                }
                Boolean minimapDisplayIsAlwaysVisible = booleanDecode("IsAlwaysVisible", 34, null);
                Boolean minimapDisplayUseTeamColor = booleanDecode("UseTeamColor", 31, null);
                Boolean minimapDisplayFollowUnitOrientation = booleanDecode("FollowUnitOrientation", 40, null);

                // TOrderConfigModuleDescriptor
                String validOrders = stringDecode("ValidOrders", 30, null);

                // TOrderableModuleDescriptor
                String unlockableOrders = stringDecode("UnlockableOrders", 31, null);

                // TTacticalLabelModuleDescriptor
                String multiSelectionSortingOrder = stringDecode("MultiSelectionSortingOrder", 45, null);
                String unitName = stringDecode("UnitName", 46, 1);

                // IdentifiedTexture
                String identifiedTexture = stringDecode("IdentifiedTexture", 36, null);
                String identifiedTextureCommandNameTrigger = stringDecode("CommandNameTrigger", 41, null);
                String identifiedTextureAlterator = stringDecode("Alterator", 32, null);

                ArrayList<String> identifiedTextureValues = blockStringDecode("Values", 25, 2);

                String defaultSpeciailtyToken = stringDecode("DefaultSpecialtyToken", 46, 1);

                // UnidentifiedTexture
                String unidentifiedTexture = stringDecode("UnidentifiedTexture", 38, null);
                String unidentifiedTextureCommandNameTrigger = stringDecode("CommandNameTrigger", 41, null);
                String unidentifiedTextureAlterator = stringDecode("Alterator", 32, null);

                ArrayList<String> unidentifiedTextureTextureValues = blockStringDecode("Values", 25, 2);
                String positionHeightOffset = stringDecode("PositionHeightOffset", 39, null);
                String nbSoldiers = null;
                String evacuationTime = null;
                String travelDuration = null;
                boolean flagHelicopter = false;
                if (!flagAircraft) {
                    nbSoldiers = stringDecode("NbSoldiers", 45, null);
                }else{
                    // TAirplaneModuleDescriptor
                    while (!(line.startsWith(")"))) {
                        if (line.contains("TAirplaneModuleDescriptor")){
                            break;
                        }else if (line.contains("TStrategicDataModuleDescriptor")){
                            flagHelicopter = true;
                            break;
                        }else{
                            line = reader.readLine();
                        }
                    }
                    if (!(flagHelicopter)){
                        evacuationTime = stringDecode("EvacuationTime", 33, null);
                        travelDuration = stringDecode("TravelDuration", 33, null);
                    }
                }

                // TStrategicDataModuleDescriptor
                String unitAttackValue = stringDecode("UnitAttackValue", 38, null);
                String unitDefenseValue = stringDecode("UnitDefenseValue", 39, null);
                String unitBonusXpPerLevelValue = stringDecode("UnitBonusXpPerLevelValue", 47, null);

                // TUnitUIModuleDescriptor
                String unitRole = stringDecode("UnitRole", 28, 1);
                ArrayList<String> specialtiesList = blockStringDecode("SpecialtiesList", 21, 2);
                String nameToken = stringDecode("NameToken", 29, 1);
                String infoPanelConfigurationToken = stringDecode("InfoPanelConfigurationToken", 47, null);
                String typeSpecificToken = stringDecode("TypeSpecificToken", 37, 1);
                String realRoadSpeed = null;
                if (!flagAircraft) {
                    realRoadSpeed = stringDecode("RealRoadSpeed", 32, null);
                }
                Boolean isAce = booleanDecode("IsAce", 24, null);
                String upgradeFromUnit = null;
                if ((line = reader.readLine()).contains("UpgradeFromUnit")) {
                    upgradeFromUnit = stringDecode("UpgradeFromUnit", 38, null);
                }
                Boolean generateName = booleanDecode("GenerateName", 31, null);
                String menuIconTexture = stringDecode("MenuIconTexture", 35, 1);
                String buttonTexture = stringDecode("ButtonTexture", 33, 1);
                String countryTexture = stringDecode("CountryTexture", 34, 1);
                String typeStrategicCount = stringDecode("TypeStrategicCount", 37, null);

                UniteDescriptor uniteDescriptor = new UniteDescriptor(descriptor, nationalite, motherCountry, acknowUnitType,
                        typeUnitFormation, initialFlagSet, useFollowCam, stickToGround, inGeoDb, porteurMustBeVisible,
                        clampInWorld, clampOutMap, relativeScanningPosition, lowAltitudeFlyingAltitude, nearGroundFlyingAltitude,
                        tTagsModuleDescriptor, experienceLevelsPackDescriptor, canWinExperience, experienceGainBySecond, experienceMultiplierBonusOnKill,
                        autoRevealType, unitConcealmentBonus, visionUnitType, unitIsStealth, hideFromDebug, pickableObject, depiction, ghostDepiction,
                        blackHoleIdentifier, gameplayBBoxBoneName, autoCoverRange, occupationRadius, terrainListMask, terrainList, useTerrainsForEscape,
                        weaponManagerDefault, weaponManagerSelection, suppressDamagesRegenRatio, suppressDamagesRegenRatioOutOfRange, stunDamagesRegen,
                        stunFreezesUnits, blindageProperties, armorDescriptorFront, armorDescriptorSides, armorDescriptorRear, armorDescriptorTop,
                        maxSuppressionDamages, maxStunDamages, maxDamages, killWhenDamagesReachMax, hitRollSize, hitRollECM, autoOrientation, skipCadavreCreation,
                        useTopArmorAgainstFire, physicalDamageLevelsPack, suppressDamageLevelsPack, stunDamageLevelsPack, dangerousness, moralLevel, maxSpeed,
                        unitMovingType, pathfindType, preferredLayerMask, vitesseCombat, speedBonusOnRoad, maxAcceleration, maxDeceleration, tempsDemiTour,
                        vehicleSubType, startTime, stopTime, rotationStartTime, rotationStopTime, fuelCapacity, fuelMoveDuration, opticsAltitudeConfig,
                        doesNotCountInScannerAbsoluteMaxRange, porteeVisionTBA, porteeVisionFOW, detectionTBA, porteeVision, porteeIdentification, opticalStrength,
                        opticalStrengthAltitude, unitDetectStealthUnit, specializedDetections, specializedOpticalStrengths, ignoreObstacles, identifyBaseProbability,
                        timeBetweenEachIdentifyRoll, visibilityRuleDescriptor, distanceMultiplierRule, multiplicateurAPorteeMaximale, multiplicateurAPorteeMinimale,
                        exposant, multiplicateurAPorteeMaximaleEnMouvement, multiplicateurAPorteeMinimaleEnMouvement, exposantEnMouvement, isTransport, transportedTexture,
                        transportedSoldier, timeToLoad, nbSeatsOccupied, isTowable, transporterCategories, transportableTagSet, nbSeatsAvailable, wreckUnloadPhysicalDamageBonus, wreckUnloadSuppressDamageBonus, wreckUnloadStunDamageBonus, loadRadius, factory,productionTime, commandPoints, resourceTickets, canAssist, assistRequestBroadcastRadius,
                        distanceToFlee, maxDistanceForOffensiveReaction, maxDistanceForOffensiveReactionOnFlyingTarget, maxDistanceForEngagement, searchedTagsInEngagementTarget,
                        minimapDisplayTexture, minimapDisplayGhostTexture, minimapDisplayIsAlwaysVisible, minimapDisplayUseTeamColor, minimapDisplayFollowUnitOrientation,
                        validOrders, unlockableOrders, multiSelectionSortingOrder, unitName, identifiedTexture, identifiedTextureCommandNameTrigger, identifiedTextureAlterator,
                        identifiedTextureValues, defaultSpeciailtyToken, unidentifiedTexture, unidentifiedTextureCommandNameTrigger, unidentifiedTextureAlterator,
                        unidentifiedTextureTextureValues, positionHeightOffset, nbSoldiers, evacuationTime, travelDuration, unitAttackValue, unitDefenseValue,
                        unitBonusXpPerLevelValue, unitRole, specialtiesList, nameToken, infoPanelConfigurationToken, typeSpecificToken, realRoadSpeed, isAce,
                        upgradeFromUnit, generateName, menuIconTexture, buttonTexture, countryTexture, typeStrategicCount);
                uniteDescriptorList.add(uniteDescriptor);
            }

        }
        reader.close();
        return uniteDescriptorList;

    }

    private String stringDecode(String str, Integer index1, Integer index2) throws IOException {
        String result = null;
         while (!(line.startsWith(")"))){
            if (line.contains(str)){
                if (index2 != null) {
                    result = line.substring(index1, line.length()-index2);
                }else{
                    result = line.substring(index1);
                }
                break;
            }
            line = reader.readLine();
        }
        return result;
    }

    private Boolean booleanDecode(String str, Integer index1, Integer index2) throws IOException {
        Boolean result = null;
        while (!(line.startsWith(")"))){
            if (line.contains(str)){
                if (index2 != null) {
                    result = Boolean.valueOf(line.substring(index1, line.length()-index2));
                }else{
                    result = Boolean.valueOf(line.substring(index1));
                }
                break;
            }
            line = reader.readLine();
        }
        return result;
    }

    private ArrayList<String> blockStringDecode(String str, Integer index1, Integer index2) throws IOException {
        String result;
        int pointer = 0;
        boolean flagFinished = false;
        ArrayList<String> resultList = new ArrayList<>();
        while (!(line.startsWith(")"))){
            if (line.contains(str)) {
                if (line.endsWith("]")) {
                    break;
                } else {
                    while (!line.endsWith("]")) {
                        line = reader.readLine();
                        if (line.contains("[")) {
                            line = reader.readLine();
                        }
                        if (!line.contains("]")) {
                            if (index2 != null) {
                                if (pointer == 1) {
                                    index2 -= 1;
                                }
                                result = line.substring(index1, line.length() - index2);
                                pointer += 1;
                            } else {
                                result = line.substring(index1);
                            }
                            resultList.add(result);
                        } else {
                            flagFinished = true;
                            break;
                        }
                    }
                }
            } else{
                if(flagFinished){
                    break;
                }else {
                    line = reader.readLine();
                }
            }
        }
        return resultList;
    }

}

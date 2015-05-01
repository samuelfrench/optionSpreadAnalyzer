CREATE DATABASE  IF NOT EXISTS `repo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `repo`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: repo
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `daily_historical`
--

DROP TABLE IF EXISTS `daily_historical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_historical` (
  `daily_historical_id` int(11) NOT NULL,
  `ticker` varchar(10) NOT NULL,
  `timestamp_load` timestamp NULL DEFAULT NULL,
  `date` varchar(45) NOT NULL,
  `open` decimal(45,0) DEFAULT NULL,
  `high` decimal(45,0) DEFAULT NULL,
  `low` decimal(45,0) DEFAULT NULL,
  `close` decimal(45,0) DEFAULT NULL,
  `volume` bigint(255) DEFAULT NULL,
  `adj_close` decimal(45,0) DEFAULT NULL,
  PRIMARY KEY (`daily_historical_id`),
  UNIQUE KEY `UNIQUE` (`ticker`,`date`),
  CONSTRAINT `daily_ticker_fk` FOREIGN KEY (`ticker`) REFERENCES `nasdaq_ticker` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_historical`
--

LOCK TABLES `daily_historical` WRITE;
/*!40000 ALTER TABLE `daily_historical` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_historical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nasdaq_ticker`
--

DROP TABLE IF EXISTS `nasdaq_ticker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nasdaq_ticker` (
  `ticker` varchar(10) NOT NULL,
  PRIMARY KEY (`ticker`),
  UNIQUE KEY `ticker_UNIQUE` (`ticker`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nasdaq_ticker`
--

LOCK TABLES `nasdaq_ticker` WRITE;
/*!40000 ALTER TABLE `nasdaq_ticker` DISABLE KEYS */;
INSERT INTO `nasdaq_ticker` VALUES ('AAIT'),('AAL'),('AAME'),('AAOI'),('AAON'),('AAPC'),('AAPL'),('AAVL'),('AAWW'),('AAXJ'),('ABAC'),('ABAX'),('ABCB'),('ABCD'),('ABCO'),('ABCW'),('ABDC'),('ABGB'),('ABIO'),('ABMD'),('ABTL'),('ABY'),('ACAD'),('ACAS'),('ACAT'),('ACET'),('ACFC'),('ACFN'),('ACGL'),('ACHC'),('ACHN'),('ACIW'),('ACLS'),('ACNB'),('ACOR'),('ACPW'),('ACRX'),('ACSF'),('ACST'),('ACTA'),('ACTG'),('ACTS'),('ACTX'),('ACUR'),('ACWI'),('ACWX'),('ACXM'),('ADAT'),('ADBE'),('ADEP'),('ADHD'),('ADI'),('ADMA'),('ADMP'),('ADMS'),('ADNC'),('ADP'),('ADRA'),('ADRD'),('ADRE'),('ADRO'),('ADRU'),('ADSK'),('ADTN'),('ADUS'),('ADVS'),('ADXS'),('ADXSW'),('AEGN'),('AEGR'),('AEHR'),('AEIS'),('AEPI'),('AERI'),('AETI'),('AEY'),('AEZS'),('AFAM'),('AFCB'),('AFFX'),('AFH'),('AFMD'),('AFOP'),('AFSI'),('AGEN'),('AGII'),('AGIIL'),('AGIO'),('AGNC'),('AGNCB'),('AGNCP'),('AGND'),('AGRX'),('AGTC'),('AGYS'),('AGZD'),('AHGP'),('AHPI'),('AIMC'),('AINV'),('AIQ'),('AIRM'),('AIRR'),('AIRT'),('AIXG'),('AKAM'),('AKAO'),('AKBA'),('AKER'),('AKRX'),('ALCO'),('ALDR'),('ALDX'),('ALGN'),('ALGT'),('ALIM'),('ALKS'),('ALLB'),('ALLT'),('ALNY'),('ALOG'),('ALOT'),('ALQA'),('ALSK'),('ALTR'),('ALXA'),('ALXN'),('AMAG'),('AMAT'),('AMBA'),('AMBC'),('AMBCW'),('AMCC'),('AMCF'),('AMCN'),('AMCX'),('AMD'),('AMDA'),('AMED'),('AMGN'),('AMIC'),('AMKR'),('AMNB'),('AMOT'),('AMOV'),('AMPH'),('AMRB'),('AMRI'),('AMRK'),('AMRN'),('AMRS'),('AMSC'),('AMSF'),('AMSG'),('AMSGP'),('AMSWA'),('AMTX'),('AMWD'),('AMZN'),('ANAC'),('ANAD'),('ANAT'),('ANCB'),('ANCI'),('ANCX'),('ANDE'),('ANGI'),('ANGO'),('ANIK'),('ANIP'),('ANSS'),('ANTH'),('ANY'),('AOSL'),('APDN'),('APDNW'),('APEI'),('APIC'),('APOG'),('APOL'),('APPS'),('APPY'),('APRI'),('APTO'),('APWC'),('AQXP'),('ARAY'),('ARCB'),('ARCC'),('ARCI'),('ARCP'),('ARCPP'),('ARCW'),('ARDM'),('ARDX'),('AREX'),('ARGS'),('ARIA'),('ARII'),('ARIS'),('ARKR'),('ARLP'),('ARMH'),('ARNA'),('AROW'),('ARQL'),('ARRS'),('ARRY'),('ARTNA'),('ARTW'),('ARTX'),('ARUN'),('ARWAU'),('ARWR'),('ASBB'),('ASBI'),('ASCMA'),('ASEI'),('ASFI'),('ASMB'),('ASMI'),('ASML'),('ASNA'),('ASND'),('ASPS'),('ASPX'),('ASRV'),('ASRVP'),('ASTC'),('ASTE'),('ASTI'),('ASUR'),('ASYS'),('ATAI'),('ATAX'),('ATEC'),('ATHN'),('ATHX'),('ATLC'),('ATLO'),('ATML'),('ATNI'),('ATNY'),('ATOS'),('ATRA'),('ATRC'),('ATRI'),('ATRM'),('ATRO'),('ATRS'),('ATSG'),('ATTU'),('ATVI'),('AUBN'),('AUDC'),('AUMA'),('AUMAU'),('AUMAW'),('AUPH'),('AVAV'),('AVEO'),('AVGO'),('AVGR'),('AVHI'),('AVID'),('AVNU'),('AVNW'),('AWAY'),('AWRE'),('AXAS'),('AXDX'),('AXGN'),('AXJS'),('AXPW'),('AXPWW'),('AXTI'),('AZPN'),('BABY'),('BAGR'),('BAMM'),('BANF'),('BANFP'),('BANR'),('BANX'),('BASI'),('BBBY'),('BBC'),('BBCN'),('BBEP'),('BBEPP'),('BBGI'),('BBLU'),('BBNK'),('BBOX'),('BBP'),('BBRG'),('BBRY'),('BBSI'),('BCBP'),('BCLI'),('BCOM'),('BCOR'),('BCOV'),('BCPC'),('BCRX'),('BDBD'),('BDCV'),('BDE'),('BDGE'),('BDMS'),('BDSI'),('BEAT'),('BEAV'),('BEBE'),('BECN'),('BELFA'),('BELFB'),('BFIN'),('BGCP'),('BGFV'),('BGMD'),('BHAC'),('BHACR'),('BHACU'),('BHACW'),('BHBK'),('BIB'),('BICK'),('BIDU'),('BIIB'),('BIND'),('BIOC'),('BIOD'),('BIOL'),('BIOS'),('BIS'),('BJRI'),('BKCC'),('BKEP'),('BKEPP'),('BKMU'),('BKSC'),('BKYF'),('BLBD'),('BLBDW'),('BLCM'),('BLDP'),('BLDR'),('BLFS'),('BLIN'),('BLKB'),('BLMN'),('BLMT'),('BLPH'),('BLRX'),('BLUE'),('BLVD'),('BLVDU'),('BLVDW'),('BMRC'),('BMRN'),('BMTC'),('BNCL'),('BNCN'),('BNDX'),('BNFT'),('BNSO'),('BOBE'),('BOCH'),('BOFI'),('BOKF'),('BONA'),('BONT'),('BOOM'),('BOSC'),('BOTA'),('BOTJ'),('BPFH'),('BPFHP'),('BPFHW'),('BPMC'),('BPOP'),('BPOPM'),('BPOPN'),('BPTH'),('BRCD'),('BRCM'),('BRDR'),('BREW'),('BRID'),('BRKL'),('BRKR'),('BRKS'),('BRLI'),('BSET'),('BSF'),('BSFT'),('BSPM'),('BSQR'),('BSRR'),('BSTC'),('BUR'),('BUSE'),('BV'),('BVA'),('BVSN'),('BWEN'),('BWFG'),('BWINA'),('BWINB'),('BWLD'),('BYBK'),('BYFC'),('BYLK'),('CA'),('CAAS'),('CAC'),('CACB'),('CACC'),('CACQ'),('CADC'),('CADT'),('CADTR'),('CADTU'),('CADTW'),('CAKE'),('CALA'),('CALD'),('CALI'),('CALL'),('CALM'),('CAMB'),('CAMBU'),('CAMBW'),('CAMP'),('CAMT'),('CAPN'),('CAPNW'),('CAPR'),('CAR'),('CARA'),('CARB'),('CARO'),('CART'),('CARV'),('CARZ'),('CASH'),('CASI'),('CASM'),('CASS'),('CASY'),('CATM'),('CATY'),('CATYW'),('CAVM'),('CBAK'),('CBAN'),('CBAY'),('CBDE'),('CBF'),('CBFV'),('CBIN'),('CBLI'),('CBMG'),('CBMX'),('CBNJ'),('CBNK'),('CBOE'),('CBPO'),('CBRL'),('CBSH'),('CBSHP'),('CBYL'),('CCBG'),('CCCL'),('CCCR'),('CCD'),('CCIH'),('CCLP'),('CCMP'),('CCNE'),('CCOI'),('CCRN'),('CCUR'),('CCXI'),('CDC'),('CDK'),('CDNA'),('CDNS'),('CDTI'),('CDTX'),('CDW'),('CDXS'),('CDZI'),('CECE'),('CECO'),('CELG'),('CELGZ'),('CEMI'),('CEMP'),('CENT'),('CENTA'),('CENX'),('CERE'),('CERN'),('CERS'),('CERU'),('CETV'),('CEVA'),('CFA'),('CFBK'),('CFFI'),('CFFN'),('CFGE'),('CFNB'),('CFNL'),('CFO'),('CFRX'),('CFRXW'),('CFRXZ'),('CG'),('CGEN'),('CGIX'),('CGNT'),('CGNX'),('CGO'),('CHCI'),('CHCO'),('CHDN'),('CHEF'),('CHEK'),('CHEKW'),('CHEV'),('CHFC'),('CHFN'),('CHI'),('CHKE'),('CHKP'),('CHLN'),('CHMG'),('CHNR'),('CHOP'),('CHRS'),('CHRW'),('CHSCL'),('CHSCM'),('CHSCN'),('CHSCO'),('CHSCP'),('CHTR'),('CHUY'),('CHW'),('CHXF'),('CHY'),('CIDM'),('CIFC'),('CINF'),('CISAW'),('CISG'),('CIZ'),('CIZN'),('CJJD'),('CKEC'),('CKSW'),('CLAC'),('CLACU'),('CLACW'),('CLBH'),('CLCD'),('CLCT'),('CLDN'),('CLDX'),('CLFD'),('CLIR'),('CLLS'),('CLMS'),('CLMT'),('CLNE'),('CLNT'),('CLRB'),('CLRBW'),('CLRO'),('CLRX'),('CLSN'),('CLTX'),('CLUB'),('CLVS'),('CLWT'),('CMCO'),('CMCSA'),('CMCSK'),('CMCT'),('CME'),('CMFN'),('CMGE'),('CMLS'),('CMPR'),('CMRX'),('CMTL'),('CNAT'),('CNBKA'),('CNCE'),('CNET'),('CNIT'),('CNLM'),('CNLMR'),('CNLMU'),('CNLMW'),('CNMD'),('CNOB'),('CNSI'),('CNSL'),('CNTF'),('CNTY'),('CNV'),('CNXR'),('CNYD'),('COB'),('COBZ'),('COHR'),('COHU'),('COKE'),('COLB'),('COLM'),('COMM'),('COMT'),('CONE'),('CONN'),('COOL'),('CORE'),('CORI'),('CORT'),('COSI'),('COST'),('COVS'),('COWN'),('COWNL'),('CPAH'),('CPGI'),('CPHC'),('CPHD'),('CPHR'),('CPIX'),('CPLA'),('CPLP'),('CPRT'),('CPRX'),('CPSH'),('CPSI'),('CPSS'),('CPST'),('CPTA'),('CPXX'),('CRAI'),('CRAY'),('CRBP'),('CRDC'),('CRDS'),('CRDT'),('CREE'),('CREG'),('CRESW'),('CRESY'),('CRIS'),('CRME'),('CRMT'),('CRNT'),('CROX'),('CRRC'),('CRTN'),('CRTO'),('CRUS'),('CRVL'),('CRWN'),('CRWS'),('CRZO'),('CSAL'),('CSBK'),('CSCD'),('CSCO'),('CSF'),('CSFL'),('CSGP'),('CSGS'),('CSII'),('CSIQ'),('CSOD'),('CSPI'),('CSQ'),('CSRE'),('CSTE'),('CSUN'),('CSWC'),('CTAS'),('CTBI'),('CTCM'),('CTCT'),('CTG'),('CTHR'),('CTIB'),('CTIC'),('CTRE'),('CTRL'),('CTRN'),('CTRP'),('CTRV'),('CTRX'),('CTSH'),('CTSO'),('CTWS'),('CTXS'),('CU'),('CUBA'),('CUI'),('CUNB'),('CUTR'),('CVBF'),('CVCO'),('CVCY'),('CVGI'),('CVGW'),('CVLT'),('CVLY'),('CVTI'),('CVV'),('CWAY'),('CWBC'),('CWCO'),('CWST'),('CXDC'),('CY'),('CYAN'),('CYBE'),('CYBR'),('CYBX'),('CYCC'),('CYCCP'),('CYHHZ'),('CYNO'),('CYOU'),('CYRN'),('CYTK'),('CYTR'),('CYTX'),('CZFC'),('CZNC'),('CZR'),('CZWI'),('DAEG'),('DAIO'),('DAKT'),('DARA'),('DATE'),('DAVE'),('DAX'),('DBVT'),('DCIX'),('DCOM'),('DCTH'),('DENN'),('DEPO'),('DERM'),('DEST'),('DFRG'),('DFVL'),('DFVS'),('DGAS'),('DGICA'),('DGICB'),('DGII'),('DGLD'),('DGLY'),('DGRE'),('DGRS'),('DGRW'),('DHIL'),('DHRM'),('DIOD'),('DISCA'),('DISCB'),('DISCK'),('DISH'),('DJCO'),('DLBL'),('DLBS'),('DLHC'),('DLTR'),('DMLP'),('DMND'),('DMRC'),('DNBF'),('DNKN'),('DORM'),('DOVR'),('DOX'),('DPRX'),('DRAD'),('DRAM'),('DRNA'),('DRRX'),('DRWI'),('DRWIW'),('DRYS'),('DSCI'),('DSCO'),('DSGX'),('DSKX'),('DSKY'),('DSLV'),('DSPG'),('DSWL'),('DTLK'),('DTSI'),('DTUL'),('DTUS'),('DTV'),('DTYL'),('DTYS'),('DVAX'),('DVCR'),('DWA'),('DWAT'),('DWCH'),('DWSN'),('DXCM'),('DXGE'),('DXJS'),('DXKW'),('DXLG'),('DXM'),('DXPE'),('DXPS'),('DXYN'),('DYAX'),('DYNT'),('DYSL'),('EA'),('EAC'),('EARS'),('EBAY'),('EBIO'),('EBIX'),('EBMT'),('EBSB'),('EBTC'),('ECHO'),('ECOL'),('ECPG'),('ECTE'),('ECYT'),('EDAP'),('EDGW'),('EDUC'),('EEFT'),('EEI'),('EEMA'),('EEME'),('EEML'),('EFII'),('EFOI'),('EFSC'),('EFUT'),('EGAN'),('EGBN'),('EGHT'),('EGLE'),('EGLT'),('EGOV'),('EGRW'),('EGRX'),('EGT'),('EHTH'),('EIGI'),('ELGX'),('ELNK'),('ELON'),('ELOS'),('ELRC'),('ELSE'),('ELTK'),('EMCB'),('EMCF'),('EMCG'),('EMCI'),('EMDI'),('EMEY'),('EMIF'),('EMITF'),('EMKR'),('EML'),('EMMS'),('EMMSP'),('ENDP'),('ENFC'),('ENG'),('ENOC'),('ENPH'),('ENSG'),('ENT'),('ENTA'),('ENTG'),('ENTL'),('ENTR'),('ENVI'),('ENZN'),('ENZY'),('EPAX'),('EPAY'),('EPIQ'),('EPRS'),('EPZM'),('EQIX'),('ERI'),('ERIC'),('ERIE'),('ERII'),('EROC'),('ERS'),('ERW'),('ESBK'),('ESCA'),('ESCR'),('ESCRP'),('ESEA'),('ESES'),('ESGR'),('ESIO'),('ESLT'),('ESMC'),('ESPR'),('ESRX'),('ESSA'),('ESSX'),('ESXB'),('ETFC'),('ETRM'),('ETSY'),('EUFN'),('EVAL'),('EVAR'),('EVBS'),('EVEP'),('EVK'),('EVLV'),('EVOK'),('EVOL'),('EWBC'),('EXA'),('EXAC'),('EXAS'),('EXEL'),('EXFO'),('EXLP'),('EXLS'),('EXPD'),('EXPE'),('EXPO'),('EXTR'),('EXXI'),('EYES'),('EZCH'),('EZPW'),('FALC'),('FANG'),('FARM'),('FARO'),('FAST'),('FATE'),('FB'),('FBIO'),('FBIZ'),('FBMS'),('FBNC'),('FBNK'),('FBRC'),('FBSS'),('FCAP'),('FCBC'),('FCCO'),('FCCY'),('FCEL'),('FCFS'),('FCHI'),('FCLF'),('FCNCA'),('FCS'),('FCSC'),('FCTY'),('FCVA'),('FCZA'),('FCZAP'),('FDEF'),('FDIV'),('FDML'),('FDUS'),('FEIC'),('FEIM'),('FELE'),('FEMB'),('FES'),('FEUZ'),('FEYE'),('FFBC'),('FFBCW'),('FFHL'),('FFIC'),('FFIN'),('FFIV'),('FFKT'),('FFNM'),('FFNW'),('FFWM'),('FGEN'),('FHCO'),('FIBK'),('FINL'),('FISH'),('FISI'),('FISV'),('FITB'),('FITBI'),('FIVE'),('FIVN'),('FIZZ'),('FLAT'),('FLDM'),('FLEX'),('FLIC'),('FLIR'),('FLKS'),('FLL'),('FLML'),('FLWS'),('FLXN'),('FLXS'),('FMB'),('FMBH'),('FMBI'),('FMER'),('FMI'),('FMNB'),('FNBC'),('FNFG'),('FNGN'),('FNHC'),('FNJN'),('FNLC'),('FNRG'),('FNSR'),('FNTC'),('FNTCU'),('FNTCW'),('FNWB'),('FOLD'),('FOMX'),('FONE'),('FONR'),('FORD'),('FORM'),('FORR'),('FORTY'),('FOSL'),('FOX'),('FOXA'),('FOXF'),('FPRX'),('FPXI'),('FRAN'),('FRBA'),('FRBK'),('FRED'),('FREE'),('FRGI'),('FRME'),('FRP'),('FRPH'),('FRPT'),('FRSH'),('FSAM'),('FSBK'),('FSBW'),('FSC'),('FSCFL'),('FSFG'),('FSFR'),('FSGI'),('FSLR'),('FSNN'),('FSRV'),('FSTR'),('FSYS'),('FTCS'),('FTD'),('FTEK'),('FTGC'),('FTHI'),('FTLB'),('FTNT'),('FTR'),('FTSL'),('FTSM'),('FUEL'),('FULL'),('FULLL'),('FULT'),('FUNC'),('FUND'),('FV'),('FWM'),('FWP'),('FWRD'),('FXCB'),('FXEN'),('FXENP'),('GABC'),('GAI'),('GAIA'),('GAIN'),('GAINO'),('GAINP'),('GALE'),('GALT'),('GALTU'),('GALTW'),('GAME'),('GARS'),('GASS'),('GBCI'),('GBDC'),('GBIM'),('GBLI'),('GBNK'),('GBSN'),('GBSNU'),('GCBC'),('GCVRZ'),('GDEF'),('GENC'),('GENE'),('GEOS'),('GERN'),('GEVA'),('GEVO'),('GFED'),('GFN'),('GFNCP'),('GFNSL'),('GGAC'),('GGACR'),('GGACU'),('GGACW'),('GGAL'),('GHDX'),('GIFI'),('GIGA'),('GIGM'),('GIII'),('GILD'),('GILT'),('GK'),('GKNT'),('GLAD'),('GLADO'),('GLBS'),('GLBZ'),('GLDC'),('GLDD'),('GLDI'),('GLMD'),('GLNG'),('GLPI'),('GLRE'),('GLRI'),('GLUU'),('GLYC'),('GMAN'),('GMCR'),('GMLP'),('GNBC'),('GNCA'),('GNCMA'),('GNMA'),('GNMK'),('GNTX'),('GNVC'),('GOGL'),('GOGO'),('GOLD'),('GOMO'),('GOOD'),('GOODN'),('GOODO'),('GOODP'),('GOOG'),('GOOGL'),('GPIC'),('GPOR'),('GPRE'),('GPRO'),('GRBK'),('GRFS'),('GRID'),('GRIF'),('GRMN'),('GROW'),('GRPN'),('GRVY'),('GSBC'),('GSIG'),('GSIT'),('GSM'),('GSOL'),('GSVC'),('GT'),('GTIM'),('GTLS'),('GTWN'),('GTXI'),('GUID'),('GULF'),('GULTU'),('GURE'),('GWGH'),('GWPH'),('GYRO'),('HA'),('HABT'),('HAFC'),('HAIN'),('HALL'),('HALO'),('HART'),('HAS'),('HAWK'),('HAWKB'),('HAYN'),('HBAN'),('HBANP'),('HBCP'),('HBHC'),('HBHCL'),('HBIO'),('HBK'),('HBMD'),('HBNC'),('HBOS'),('HBP'),('HCAP'),('HCAPL'),('HCBK'),('HCCI'),('HCKT'),('HCOM'),('HCSG'),('HDNG'),('HDP'),('HDRA'),('HDRAR'),('HDRAU'),('HDRAW'),('HDS'),('HDSN'),('HEAR'),('HEES'),('HELE'),('HEOP'),('HERO'),('HFBC'),('HFBL'),('HFFC'),('HFWA'),('HGSH'),('HIBB'),('HIFS'),('HIHO'),('HIIQ'),('HILL'),('HIMX'),('HKTV'),('HLIT'),('HMHC'),('HMIN'),('HMNF'),('HMNY'),('HMPR'),('HMST'),('HMSY'),('HMTV'),('HNH'),('HNNA'),('HNRG'),('HNSN'),('HOFT'),('HOLI'),('HOLX'),('HOMB'),('HOTR'),('HOTRW'),('HOVNP'),('HPJ'),('HPTX'),('HQCL'),('HQY'),('HRMN'),('HRMNU'),('HRMNW'),('HRTX'),('HRZN'),('HSGX'),('HSIC'),('HSII'),('HSKA'),('HSNI'),('HSON'),('HSTM'),('HTBI'),('HTBK'),('HTBX'),('HTCH'),('HTHT'),('HTLD'),('HTLF'),('HTWR'),('HUBG'),('HURC'),('HURN'),('HWAY'),('HWBK'),('HWCC'),('HWKN'),('HYGS'),('HYLS'),('HYND'),('HYZD'),('HZNP'),('IACI'),('IART'),('IBB'),('IBCP'),('IBKC'),('IBKR'),('IBOC'),('IBTX'),('ICAD'),('ICBK'),('ICCC'),('ICEL'),('ICFI'),('ICLD'),('ICLDW'),('ICLN'),('ICLR'),('ICON'),('ICPT'),('ICUI'),('IDCC'),('IDRA'),('IDSA'),('IDSY'),('IDTI'),('IDXX'),('IEP'),('IESC'),('IEUS'),('IFAS'),('IFEU'),('IFGL'),('IFNA'),('IFON'),('IFV'),('IGLD'),('IGOV'),('IGTE'),('III'),('IIIN'),('IIJI'),('IILG'),('IIN'),('IIVI'),('IKAN'),('IKGH'),('IKNX'),('ILMN'),('IMDZ'),('IMGN'),('IMI'),('IMKTA'),('IMMR'),('IMMU'),('IMMY'),('IMNP'),('IMOS'),('IMRS'),('INAP'),('INBK'),('INCR'),('INCY'),('INDB'),('INDY'),('INFA'),('INFI'),('INFN'),('INGN'),('ININ'),('INNL'),('INO'),('INOD'),('INOV'),('INPH'),('INSM'),('INSY'),('INTC'),('INTG'),('INTL'),('INTLL'),('INTU'),('INTX'),('INVE'),('INVT'),('INWK'),('IOSP'),('IPAR'),('IPAS'),('IPCC'),('IPCI'),('IPCM'),('IPDN'),('IPGP'),('IPHS'),('IPKW'),('IPWR'),('IPXL'),('IQNT'),('IRBT'),('IRCP'),('IRDM'),('IRDMB'),('IRG'),('IRIX'),('IRMD'),('IROQ'),('IRWD'),('ISBC'),('ISCA'),('ISHG'),('ISIG'),('ISIL'),('ISIS'),('ISLE'),('ISM'),('ISNS'),('ISRG'),('ISRL'),('ISSC'),('ISSI'),('ISTR'),('ITCI'),('ITEK'),('ITIC'),('ITRI'),('ITRN'),('IVAC'),('IXYS'),('JACK'),('JAKK'),('JASN'),('JASNW'),('JASO'),('JAXB'),('JAZZ'),('JBHT'),('JBLU'),('JBSS'),('JCOM'),('JCS'),('JCTCF'),('JD'),('JDSU'),('JGBB'),('JIVE'),('JJSF'),('JKHY'),('JMBA'),('JNP'),('JOBS'),('JOEZ'),('JOUT'),('JRJC'),('JRVR'),('JSM'),('JST'),('JTPY'),('JUNO'),('JVA'),('JXSB'),('JYNT'),('KALU'),('KANG'),('KBAL'),('KBIO'),('KBSF'),('KCAP'),('KCLI'),('KE'),('KELYA'),('KELYB'),('KEQU'),('KERX'),('KEYW'),('KFFB'),('KFRC'),('KFX'),('KGJI'),('KIN'),('KINS'),('KIRK'),('KITE'),('KLAC'),('KLIC'),('KLXI'),('KMDA'),('KMPH'),('KNDI'),('KONA'),('KONE'),('KOOL'),('KOPN'),('KOSS'),('KPTI'),('KRFT'),('KRNT'),('KRNY'),('KTCC'),('KTEC'),('KTOS'),('KTWO'),('KUTV'),('KVHI'),('KWEB'),('KYTH'),('KZ'),('LABC'),('LABL'),('LACO'),('LAKE'),('LALT'),('LAMR'),('LANC'),('LAND'),('LARK'),('LAWS'),('LAYN'),('LBAI'),('LBIO'),('LBIX'),('LBRDA'),('LBRDK'),('LBTYA'),('LBTYB'),('LBTYK'),('LCNB'),('LCUT'),('LDRH'),('LDRI'),('LE'),('LECO'),('LEDS'),('LENS'),('LFUS'),('LFVN'),('LGCY'),('LGCYO'),('LGCYP'),('LGIH'),('LGND'),('LHCG'),('LIME'),('LINC'),('LINE'),('LION'),('LIOX'),('LIQD'),('LIVE'),('LJPC'),('LKFN'),('LKQ'),('LLEX'),('LLNW'),('LLTC'),('LMAT'),('LMBS'),('LMCA'),('LMCB'),('LMCK'),('LMIA'),('LMNR'),('LMNS'),('LMNX'),('LMOS'),('LMRK'),('LNBB'),('LNCE'),('LNCO'),('LNDC'),('LOAN'),('LOCM'),('LOCO'),('LOGI'),('LOGM'),('LOJN'),('LONG'),('LOOK'),('LOPE'),('LORL'),('LOXO'),('LPCN'),('LPLA'),('LPNT'),('LPSB'),('LPSN'),('LPTH'),('LPTN'),('LQDT'),('LRAD'),('LRCX'),('LSBK'),('LSCC'),('LSTR'),('LTBR'),('LTRE'),('LTRPA'),('LTRPB'),('LTRX'),('LTXB'),('LULU'),('LUNA'),('LVNTA'),('LVNTB'),('LWAY'),('LXRX'),('LYTS'),('MACK'),('MAG'),('MAGS'),('MAMS'),('MANH'),('MANT'),('MAR'),('MARA'),('MARK'),('MARPS'),('MASI'),('MAT'),('MATR'),('MATW'),('MAYS'),('MBCN'),('MBFI'),('MBFIP'),('MBII'),('MBLX'),('MBRG'),('MBSD'),('MBTF'),('MBUU'),('MBVT'),('MBWM'),('MCBC'),('MCBK'),('MCEP'),('MCGC'),('MCHP'),('MCHX'),('MCOX'),('MCRI'),('MCRL'),('MCUR'),('MDAS'),('MDCA'),('MDCO'),('MDIV'),('MDLZ'),('MDM'),('MDRX'),('MDSO'),('MDSY'),('MDVN'),('MDVX'),('MDVXW'),('MDWD'),('MDXG'),('MEET'),('MEIL'),('MEILW'),('MEILZ'),('MEIP'),('MELA'),('MELI'),('MELR'),('MEMP'),('MENT'),('MEOH'),('MERC'),('MERU'),('METR'),('MFLX'),('MFNC'),('MFRI'),('MFRM'),('MFSF'),('MGCD'),('MGEE'),('MGI'),('MGIC'),('MGLN'),('MGNX'),('MGPI'),('MGRC'),('MGYR'),('MHGC'),('MHLD'),('MHLDO'),('MICT'),('MICTW'),('MIDD'),('MIFI'),('MIK'),('MIND'),('MINI'),('MITK'),('MITL'),('MKSI'),('MKTO'),('MKTX'),('MLAB'),('MLHR'),('MLNK'),('MLNX'),('MLVF'),('MMAC'),('MMLP'),('MMSI'),('MMYT'),('MNDO'),('MNGA'),('MNKD'),('MNOV'),('MNRK'),('MNRO'),('MNST'),('MNTA'),('MNTX'),('MOBI'),('MOBL'),('MOCO'),('MOFG'),('MOKO'),('MOLG'),('MOMO'),('MORN'),('MOSY'),('MPAA'),('MPB'),('MPEL'),('MPET'),('MPWR'),('MRCC'),('MRCY'),('MRD'),('MRGE'),('MRKT'),('MRLN'),('MRNS'),('MRTN'),('MRTX'),('MRVC'),('MRVL'),('MSBF'),('MSCC'),('MSEX'),('MSFG'),('MSFT'),('MSG'),('MSLI'),('MSON'),('MSTR'),('MTBC'),('MTEX'),('MTGE'),('MTGEP'),('MTLS'),('MTRX'),('MTSC'),('MTSI'),('MTSL'),('MTSN'),('MU'),('MULT'),('MVIS'),('MXIM'),('MXWL'),('MYGN'),('MYL'),('MYOS'),('MYRG'),('MZOR'),('NAII'),('NAME'),('NANO'),('NATH'),('NATI'),('NATL'),('NATR'),('NAUH'),('NAVG'),('NAVI'),('NBBC'),('NBIX'),('NBN'),('NBS'),('NBTB'),('NCIT'),('NCLH'),('NCMI'),('NCOM'),('NCTY'),('NDAQ'),('NDLS'),('NDRM'),('NDSN'),('NECB'),('NEO'),('NEOG'),('NEON'),('NEOT'),('NEPT'),('NERV'),('NETE'),('NEWP'),('NEWS'),('NEWT'),('NFBK'),('NFEC'),('NFLX'),('NGHC'),('NGHCO'),('NGHCP'),('NHLD'),('NHTB'),('NHTC'),('NICE'),('NICK'),('NILE'),('NKSH'),('NKTR'),('NLNK'),('NLST'),('NMIH'),('NMRX'),('NNBR'),('NPBC'),('NRCIA'),('NRCIB'),('NRIM'),('NRX'),('NSEC'),('NSIT'),('NSPH'),('NSSC'),('NSTG'),('NSYS'),('NTAP'),('NTCT'),('NTES'),('NTGR'),('NTIC'),('NTK'),('NTLS'),('NTRI'),('NTRS'),('NTRSP'),('NTWK'),('NUAN'),('NURO'),('NUTR'),('NUVA'),('NVAX'),('NVCN'),('NVDA'),('NVDQ'),('NVEC'),('NVEE'),('NVET'),('NVFY'),('NVGN'),('NVIV'),('NVMI'),('NVSL'),('NWBI'),('NWBO'),('NWBOW'),('NWFL'),('NWLI'),('NWPX'),('NWS'),('NWSA'),('NXPI'),('NXST'),('NXTD'),('NXTDW'),('NXTM'),('NYMT'),('NYMTP'),('NYMX'),('NYNY'),('OBAS'),('OBCI'),('OCAT'),('OCC'),('OCFC'),('OCLR'),('OCLS'),('OCLSW'),('OCRX'),('OCUL'),('ODFL'),('ODP'),('OFED'),('OFIX'),('OFLX'),('OFS'),('OGXI'),('OHAI'),('OHGI'),('OHRP'),('OIIM'),('OKSB'),('OLBK'),('OLED'),('OMAB'),('OMCL'),('OMED'),('OMER'),('OMEX'),('ON'),('ONB'),('ONCE'),('ONCY'),('ONEQ'),('ONFC'),('ONTX'),('ONTY'),('ONVI'),('OPB'),('OPHC'),('OPHT'),('OPOF'),('OPTT'),('OPXA'),('OPXAW'),('ORBC'),('ORBK'),('OREX'),('ORIG'),('ORIT'),('ORLY'),('ORMP'),('ORPN'),('ORRF'),('OSBC'),('OSBCP'),('OSHC'),('OSIR'),('OSIS'),('OSM'),('OSN'),('OSTK'),('OSUR'),('OTEL'),('OTEX'),('OTIC'),('OTIV'),('OTTR'),('OUTR'),('OVAS'),('OVBC'),('OVLY'),('OVTI'),('OXBR'),('OXBRW'),('OXFD'),('OXGN'),('OXLC'),('OXLCN'),('OXLCO'),('OXLCP'),('OZRK'),('PAAS'),('PACB'),('PACW'),('PAGG'),('PAHC'),('PANL'),('PARN'),('PATI'),('PATK'),('PAYX'),('PBCP'),('PBCT'),('PBHC'),('PBIB'),('PBIP'),('PBMD'),('PBPB'),('PBSK'),('PCAR'),('PCBK'),('PCCC'),('PCH'),('PCLN'),('PCMI'),('PCO'),('PCOM'),('PCRX'),('PCTI'),('PCTY'),('PCYC'),('PCYG'),('PCYO'),('PDBC'),('PDCE'),('PDCO'),('PDEX'),('PDFS'),('PDII'),('PDLI'),('PDVW'),('PEBK'),('PEBO'),('PEGA'),('PEGI'),('PEIX'),('PENN'),('PERF'),('PERI'),('PERY'),('PESI'),('PETS'),('PETX'),('PFBC'),('PFBI'),('PFBX'),('PFIE'),('PFIN'),('PFIS'),('PFLT'),('PFMT'),('PFPT'),('PFSW'),('PGC'),('PGNX'),('PGTI'),('PHII'),('PHIIK'),('PHMD'),('PICO'),('PIH'),('PINC'),('PKBK'),('PKOH'),('PKT'),('PLAB'),('PLAY'),('PLBC'),('PLCE'),('PLCM'),('PLKI'),('PLMT'),('PLNR'),('PLPC'),('PLPM'),('PLTM'),('PLUG'),('PLUS'),('PLXS'),('PMBC'),('PMCS'),('PMD'),('PME'),('PMFG'),('PNBK'),('PNFP'),('PNNT'),('PNQI'),('PNRA'),('PNRG'),('PNTR'),('PODD'),('POOL'),('POPE'),('POWI'),('POWL'),('POZN'),('PPBI'),('PPC'),('PPHM'),('PPHMP'),('PPSI'),('PRAA'),('PRAH'),('PRAN'),('PRCP'),('PRFT'),('PRFZ'),('PRGN'),('PRGNL'),('PRGS'),('PRGX'),('PRIM'),('PRKR'),('PRMW'),('PROV'),('PRPH'),('PRQR'),('PRSC'),('PRSN'),('PRSS'),('PRTA'),('PRTK'),('PRTO'),('PRTS'),('PRXI'),('PRXL'),('PSAU'),('PSBH'),('PSCC'),('PSCD'),('PSCE'),('PSCF'),('PSCH'),('PSCI'),('PSCM'),('PSCT'),('PSCU'),('PSDV'),('PSEC'),('PSEM'),('PSIX'),('PSMT'),('PSTB'),('PSTI'),('PSTR'),('PSUN'),('PTBI'),('PTBIW'),('PTC'),('PTCT'),('PTEN'),('PTIE'),('PTLA'),('PTNR'),('PTNT'),('PTSI'),('PTX'),('PULB'),('PUMP'),('PVTB'),('PVTBP'),('PWOD'),('PWRD'),('PWX'),('PXLW'),('PZZA'),('QABA'),('QADA'),('QADB'),('QAT'),('QBAK'),('QCCO'),('QCLN'),('QCOM'),('QCRH'),('QDEL'),('QGEN'),('QINC'),('QIWI'),('QKLS'),('QLGC'),('QLIK'),('QLTI'),('QLTY'),('QLYS'),('QNST'),('QPAC'),('QPACU'),('QPACW'),('QQEW'),('QQQ'),('QQQC'),('QQQX'),('QQXT'),('QRHC'),('QRVO'),('QSII'),('QTEC'),('QTNT'),('QTNTW'),('QTWW'),('QUIK'),('QUMU'),('QUNR'),('QURE'),('QVCA'),('QVCB'),('QYLD'),('RADA'),('RAIL'),('RAND'),('RARE'),('RAVE'),('RAVN'),('RBCAA'),('RBCN'),('RBPAA'),('RCII'),('RCKY'),('RCMT'),('RCON'),('RCPI'),('RCPT'),('RDCM'),('RDEN'),('RDHL'),('RDI'),('RDIB'),('RDNT'),('RDUS'),('RDVY'),('RDWR'),('RECN'),('REDF'),('REFR'),('REGI'),('REGN'),('REIS'),('RELL'),('RELV'),('RELY'),('REMY'),('RENT'),('REPH'),('RESN'),('REXI'),('REXX'),('RFIL'),('RGCO'),('RGDO'),('RGDX'),('RGEN'),('RGLD'),('RGLS'),('RGSE'),('RIBT'),('RIBTW'),('RICK'),('RIGL'),('RITT'),('RITTW'),('RIVR'),('RJET'),('RLJE'),('RLOC'),('RLOG'),('RLYP'),('RMBS'),('RMCF'),('RMGN'),('RMTI'),('RNET'),('RNST'),('RNWK'),('ROBO'),('ROCK'),('ROIA'),('ROIAK'),('ROIC'),('ROIQ'),('ROIQU'),('ROIQW'),('ROKA'),('ROLL'),('ROSE'),('ROSG'),('ROST'),('ROVI'),('ROYL'),('RP'),('RPRX'),('RPRXW'),('RPRXZ'),('RPTP'),('RPXC'),('RRD'),('RRGB'),('RRM'),('RSTI'),('RSYS'),('RTGN'),('RTIX'),('RTK'),('RTRX'),('RUSHA'),('RUSHB'),('RUTH'),('RVLT'),('RVNC'),('RVSB'),('RWLK'),('RXDX'),('RXII'),('RYAAY'),('SAAS'),('SABR'),('SAEX'),('SAFM'),('SAFT'),('SAGE'),('SAIA'),('SAJA'),('SAL'),('SALE'),('SALM'),('SAMG'),('SANM'),('SANW'),('SANWZ'),('SASR'),('SATS'),('SAVE'),('SBAC'),('SBBX'),('SBCF'),('SBCP'),('SBFG'),('SBFGP'),('SBGI'),('SBLK'),('SBLKL'),('SBNY'),('SBNYW'),('SBRA'),('SBRAP'),('SBSA'),('SBSI'),('SBUX'),('SCAI'),('SCHL'),('SCHN'),('SCLN'),('SCMP'),('SCOK'),('SCON'),('SCOR'),('SCSC'),('SCSS'),('SCTY'),('SCVL'),('SCYX'),('SEAC'),('SEDG'),('SEED'),('SEIC'),('SEMI'),('SENEA'),('SENEB'),('SEV'),('SFBC'),('SFBS'),('SFLY'),('SFM'),('SFNC'),('SFST'),('SFXE'),('SGBK'),('SGC'),('SGEN'),('SGI'),('SGMA'),('SGMO'),('SGMS'),('SGNL'),('SGNT'),('SGOC'),('SGRP'),('SGYP'),('SGYPU'),('SGYPW'),('SHBI'),('SHEN'),('SHIP'),('SHLD'),('SHLDW'),('SHLM'),('SHLO'),('SHOO'),('SHOR'),('SHOS'),('SHPG'),('SIAL'),('SIBC'),('SIEB'),('SIEN'),('SIFI'),('SIFY'),('SIGI'),('SIGM'),('SILC'),('SIMO'),('SINA'),('SINO'),('SIRI'),('SIRO'),('SIVB'),('SIVBO'),('SIXD'),('SKBI'),('SKIS'),('SKOR'),('SKUL'),('SKYS'),('SKYW'),('SKYY'),('SLAB'),('SLCT'),('SLGN'),('SLM'),('SLMAP'),('SLMBP'),('SLP'),('SLRC'),('SLTC'),('SLTD'),('SLVO'),('SMAC'),('SMACR'),('SMACU'),('SMBC'),('SMCI'),('SMCP'),('SMED'),('SMIT'),('SMLR'),('SMMF'),('SMMT'),('SMRT'),('SMSI'),('SMT'),('SMTC'),('SMTP'),('SMTX'),('SNAK'),('SNBC'),('SNC'),('SNCR'),('SNDK'),('SNFCA'),('SNHY'),('SNMX'),('SNPS'),('SNSS'),('SNTA'),('SOCB'),('SOCL'),('SODA'),('SOFO'),('SOHO'),('SOHOL'),('SOHOM'),('SOHU'),('SONA'),('SONC'),('SONS'),('SORL'),('SOXX'),('SP'),('SPAN'),('SPAR'),('SPCB'),('SPDC'),('SPEX'),('SPHS'),('SPIL'),('SPKE'),('SPLK'),('SPLS'),('SPNC'),('SPNS'),('SPOK'),('SPPI'),('SPPR'),('SPPRO'),('SPPRP'),('SPRO'),('SPRT'),('SPSC'),('SPTN'),('SPU'),('SPWH'),('SPWR'),('SQBG'),('SQBK'),('SQI'),('SQNM'),('SQQQ'),('SRCE'),('SRCL'),('SRDX'),('SRET'),('SREV'),('SRNE'),('SRPT'),('SRSC'),('SSB'),('SSBI'),('SSFN'),('SSH'),('SSNC'),('SSRG'),('SSRI'),('SSYS'),('STAA'),('STB'),('STBA'),('STBZ'),('STCK'),('STDY'),('STEM'),('STFC'),('STKL'),('STLD'),('STLY'),('STML'),('STMP'),('STNR'),('STPP'),('STRA'),('STRL'),('STRM'),('STRN'),('STRS'),('STRT'),('STRZA'),('STRZB'),('STX'),('STXS'),('SUBK'),('SUMR'),('SUNS'),('SUPN'),('SURG'),('SUSQ'),('SUTR'),('SVA'),('SVBI'),('SVVC'),('SWHC'),('SWIR'),('SWKS'),('SWSH'),('SYBT'),('SYKE'),('SYMC'),('SYMX'),('SYNA'),('SYNC'),('SYNL'),('SYNT'),('SYPR'),('SYRX'),('SYUT'),('SZMK'),('SZYM'),('TACO'),('TACOU'),('TACOW'),('TACT'),('TAIT'),('TANH'),('TAPR'),('TASR'),('TAST'),('TATT'),('TAX'),('TAXI'),('TAYD'),('TBBK'),('TBIO'),('TBK'),('TBNK'),('TBPH'),('TCBI'),('TCBIL'),('TCBIP'),('TCBIW'),('TCBK'),('TCCO'),('TCFC'),('TCON'),('TCPC'),('TCRD'),('TCX'),('TDIV'),('TEAR'),('TECD'),('TECH'),('TECU'),('TEDU'),('TENX'),('TERP'),('TESO'),('TESS'),('TFM'),('TFSC'),('TFSCR'),('TFSCU'),('TFSCW'),('TFSL'),('TGA'),('TGEN'),('TGLS'),('TGTX'),('THFF'),('THLD'),('THOR'),('THRM'),('THRX'),('THST'),('THTI'),('TICC'),('TIGR'),('TILE'),('TINY'),('TIPT'),('TISA'),('TITN'),('TIVO'),('TKAI'),('TKMR'),('TLF'),('TLMR'),('TLOG'),('TNAV'),('TNDM'),('TNGO'),('TNXP'),('TOPS'),('TORM'),('TOUR'),('TOWN'),('TQQQ'),('TRAK'),('TRCB'),('TRCH'),('TREE'),('TRGT'),('TRIB'),('TRIL'),('TRIP'),('TRIV'),('TRMB'),('TRMK'),('TRNS'),('TRNX'),('TROV'),('TROVU'),('TROVW'),('TROW'),('TRS'),('TRST'),('TRTL'),('TRTLU'),('TRTLW'),('TRUE'),('TRVN'),('TSBK'),('TSC'),('TSCO'),('TSEM'),('TSLA'),('TSRA'),('TSRE'),('TSRI'),('TSRO'),('TST'),('TSYS'),('TTEC'),('TTEK'),('TTGT'),('TTHI'),('TTMI'),('TTOO'),('TTPH'),('TTS'),('TTWO'),('TUBE'),('TUES'),('TUSA'),('TUTT'),('TVIX'),('TVIZ'),('TW'),('TWER'),('TWIN'),('TWMC'),('TWOU'),('TXN'),('TXRH'),('TYPE'),('TZOO'),('UACL'),('UAE'),('UBCP'),('UBFO'),('UBIC'),('UBNK'),('UBNT'),('UBOH'),('UBSH'),('UBSI'),('UCBA'),('UCBI'),('UCFC'),('UCTT'),('UDF'),('UEIC'),('UEPS'),('UFCS'),('UFPI'),('UFPT'),('UG'),('UGLD'),('UHAL'),('UIHC'),('UK'),('ULBI'),('ULTA'),('ULTI'),('ULTR'),('UMBF'),('UMPQ'),('UNAM'),('UNB'),('UNFI'),('UNIS'),('UNTD'),('UNTY'),('UNXL'),('UPIP'),('UPLD'),('URBN'),('URRE'),('USAK'),('USAP'),('USAT'),('USATP'),('USBI'),('USCR'),('USEG'),('USLM'),('USLV'),('USMD'),('USTR'),('UTEK'),('UTHR'),('UTIW'),('UTMD'),('UTSI'),('UVSP'),('VA'),('VALU'),('VALX'),('VASC'),('VBFC'),('VBIV'),('VBLT'),('VBND'),('VBTX'),('VCEL'),('VCIT'),('VCLT'),('VCSH'),('VCYT'),('VDSI'),('VDTH'),('VECO'),('VGGL'),('VGIT'),('VGLT'),('VGSH'),('VIA'),('VIAB'),('VIAS'),('VICL'),('VICR'),('VIDI'),('VIEW'),('VIIX'),('VIIZ'),('VIMC'),('VIP'),('VIRC'),('VIRT'),('VISN'),('VIVO'),('VKTX'),('VLGEA'),('VLTC'),('VLYWW'),('VMBS'),('VNDA'),('VNET'),('VNOM'),('VNQI'),('VNR'),('VNRAP'),('VNRBP'),('VNRCP'),('VOD'),('VONE'),('VONG'),('VONV'),('VOXX'),('VPCO'),('VRA'),('VRAY'),('VRML'),('VRNG'),('VRNGW'),('VRNS'),('VRNT'),('VRSK'),('VRSN'),('VRTA'),('VRTB'),('VRTS'),('VRTU'),('VRTX'),('VSAR'),('VSAT'),('VSCP'),('VSEC'),('VSTM'),('VTAE'),('VTHR'),('VTIP'),('VTL'),('VTNR'),('VTWG'),('VTWO'),('VTWV'),('VUSE'),('VUZI'),('VVUS'),('VWOB'),('VWR'),('VXUS'),('VYFC'),('WABC'),('WAFD'),('WAFDW'),('WASH'),('WATT'),('WAVX'),('WAYN'),('WB'),('WBA'),('WBB'),('WBKC'),('WBMD'),('WDC'),('WDFC'),('WEBK'),('WEN'),('WERN'),('WETF'),('WEYS'),('WFBI'),('WFD'),('WFM'),('WGBS'),('WHF'),('WHFBL'),('WHLM'),('WHLR'),('WHLRP'),('WHLRW'),('WIBC'),('WIFI'),('WILC'),('WILN'),('WIN'),('WINA'),('WIRE'),('WIX'),('WLB'),('WLDN'),('WLFC'),('WLRH'),('WLRHU'),('WLRHW'),('WMAR'),('WMGI'),('WMGIZ'),('WOOD'),('WOOF'),('WOWO'),('WPCS'),('WPPGY'),('WPRT'),('WRES'),('WRLD'),('WSBC'),('WSBF'),('WSCI'),('WSFS'),('WSFSL'),('WSTC'),('WSTG'),('WSTL'),('WTBA'),('WTFC'),('WTFCW'),('WVFC'),('WVVI'),('WWD'),('WWWW'),('WYNN'),('XBIT'),('XBKS'),('XCRA'),('XENE'),('XENT'),('XGTI'),('XGTIW'),('XIV'),('XLNX'),('XLRN'),('XNCR'),('XNET'),('XNPT'),('XOMA'),('XONE'),('XOOM'),('XPLR'),('XRAY'),('XTLB'),('XXIA'),('YDIV'),('YDLE'),('YHOO'),('YNDX'),('YOD'),('YORW'),('YPRO'),('YRCW'),('YY'),('Z'),('ZAGG'),('ZAIS'),('ZAZA'),('ZBRA'),('ZEUS'),('ZFGN'),('ZGNX'),('ZHNE'),('ZINC'),('ZION'),('ZIONW'),('ZIONZ'),('ZIOP'),('ZIV'),('ZIXI'),('ZJZZT'),('ZLTQ'),('ZN'),('ZNGA'),('ZNWAA'),('ZSAN'),('ZSPH'),('ZU'),('ZUMZ'),('ZVZZT'),('ZWZZT'),('ZXYZ.A'),('ZXZZT');
/*!40000 ALTER TABLE `nasdaq_ticker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'repo'
--

--
-- Dumping routines for database 'repo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-01 15:24:44

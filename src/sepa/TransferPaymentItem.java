package sepa;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TransferPaymentItem {
	/*
	
	 2.28  	 	     DirectDebitTransactionInformation  	 DirectDebitTransactionInformation  	<DrctDbtTxInf>	++	02.17	 [1..n]  	 	R
 2.29  	 	         PaymentIdentification  	 PaymentIdentification  	<PmtId>	+++	02.17.01	 [1..1]  	 	R
 2.30  	 	             InstructionIdentification  	 InstructionIdentification  	<InstrId>	++++	02.17.01.01	 [0..1]  	 Text  	BD
 2.31  	 	             EndToEndIdentification  	 EndToEndIdentification  	<EndToEndId>	++++	02.17.01.02	 [1..1]  	 Text  	R
 2.32  	 	         PaymentTypeInformation  	 PaymentTypeInformation  	<PmtTpInf>	+++	02.17.02	 [0..1]  	 	C
 2.33  	 	             InstructionPriority  	 InstructionPriority  	<InstrPrty>	++++	02.17.02.01	 [0..1]  	 Code  	BD
 2.34  	 	             ServiceLevel  	 ServiceLevel  	<SvcLvl>	++++	02.17.02.02	 [0..1]  	 	R
 2.35  	 {Or  	                 Code  	 Code  	<Cd>	+++++	02.17.02.02.01	 [1..1]  	 Code  	XOR
 2.36  	 Or}  	                 Proprietary  	 Proprietary  	<Prtry>	+++++	02.17.02.02.02	 [1..1]  	 Text  	XOR
 2.37  	 	             LocalInstrument  	 LocalInstrument  	<LclInstrm>	++++	02.17.02.03	 [0..1]  	 	C
 2.38  	 {Or  	                 Code  	 Code  	<Cd>	+++++	02.17.02.03.01	 [1..1]  	 Code  	XOR
 2.39  	 Or}  	                 Proprietary  	 Proprietary  	<Prtry>	+++++	02.17.02.03.02	 [1..1]  	 Text  	XOR
 2.40  	 	             SequenceType  	 SequenceType  	<SeqTp>	++++	02.17.02.04	 [0..1]  	 Code  	C
 2.41  	 	             CategoryPurpose  	 CategoryPurpose  	<CtgyPurp>	++++	02.17.02.05	 [0..1]  	 	C
 2.42  	 {Or  	                 Code  	 Code  	<Cd>	+++++	02.17.02.05.01	 [1..1]  	 Code  	XOR
 2.43  	 Or}  	                 Proprietary  	 Proprietary  	<Prtry>	+++++	02.17.02.05.02	 [1..1]  	 Text  	XOR
 2.44  	 	         InstructedAmount  	 InstructedAmount  	<InstdAmt Ccy="AAA">	+++	02.17.03	 [1..1]  	 Amount  	R
 2.45  	 	         ChargeBearer  	 ChargeBearer  	<ChrgBr>	+++	02.17.04	 [0..1]  	 Code  	C
 2.46  	 	         DirectDebitTransaction  	 DirectDebitTransaction  	<DrctDbtTx>	+++	02.17.05	 [0..1]  	 	C
 2.47  	 	             MandateRelatedInformation  	 MandateRelatedInformation  	<MndtRltdInf>	++++	02.17.05.01	 [0..1]  	 	C
 2.48  	 	                 MandateIdentification  	 MandateIdentification  	<MndtId>	+++++	02.17.05.01.01	 [0..1]  	 Text  	C
 2.49  	 	                 DateOfSignature  	 DateOfSignature  	<DtOfSgntr>	+++++	02.17.05.01.02	 [0..1]  	 DateTime  	C
 2.50  	 	                 AmendmentIndicator  	 AmendmentIndicator  	<AmdmntInd>	+++++	02.17.05.01.03	 [0..1]  	 Indicator  	C
 2.51  	 	                 AmendmentInformationDetails  	 AmendmentInformationDetails  	<AmdmntInfDtls>	+++++	02.17.05.01.04	 [0..1]  	 	C
 2.52  	 	                     OriginalMandateIdentification  	 OriginalMandateIdentification  	<OrgnlMndtId>	++++++	02.17.05.01.04.01	 [0..1]  	 Text  	C
 2.53  	 	                     OriginalCreditorSchemeIdentification	 OriginalCreditorSchemeIdentification	<OrgnlCdtrSchmeId>	++++++	02.17.05.01.04.02	 [0..1]  	   	C
 9.1.0  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.05.01.04.02.01	 [0..1]  	 Text  	BD
 9.1.1  	 	                         PostalAddress  	 PostalAddress  	<PstlAdr>	+++++++	02.17.05.01.04.02.02	 [0..1]  	 	NU
 9.1.2  	 	                             AddressType  	 AddressType  	<AdrTp>	++++++++	02.17.05.01.04.02.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                             Department  	 Department  	<Dept>	++++++++	02.17.05.01.04.02.02.02	 [0..1]  	 Text  	NU
 9.1.4  	 	                             SubDepartment  	 SubDepartment  	<SubDept>	++++++++	02.17.05.01.04.02.02.03	 [0..1]  	 Text  	NU
 9.1.5  	 	                             StreetName  	 StreetName  	<StrtNm>	++++++++	02.17.05.01.04.02.02.04	 [0..1]  	 Text  	NU
 9.1.6  	 	                             BuildingNumber  	 BuildingNumber  	<BldgNb>	++++++++	02.17.05.01.04.02.02.05	 [0..1]  	 Text  	NU
 9.1.7  	 	                             PostCode  	 PostCode  	<PstCd>	++++++++	02.17.05.01.04.02.02.06	 [0..1]  	 Text  	NU
 9.1.8  	 	                             TownName  	 TownName  	<TwnNm>	++++++++	02.17.05.01.04.02.02.07	 [0..1]  	 Text  	NU
 9.1.9  	 	                             CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++++++	02.17.05.01.04.02.02.08	 [0..1]  	 Text  	NU
 9.1.10  	 	                             Country  	 Country  	<Ctry>	++++++++	02.17.05.01.04.02.02.09	 [0..1]  	 Code  	NU
 9.1.11  	 	                             AddressLine  	 AddressLine  	<AdrLine>	++++++++	02.17.05.01.04.02.02.10	 [0..7]  	 Text  	NU
 9.1.12  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.05.01.04.02.03	 [0..1]  	 	C
 9.1.13  	 {Or  	                             OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	++++++++	02.17.05.01.04.02.03.01	 [1..1]  	 	XOR
 9.1.14  	 	                                 BICOrBEI  	 BICOrBEI  	<BICOrBEI>	+++++++++	02.17.05.01.04.02.03.01.01	 [0..1]  	 Identifier  	C
 9.1.15  	 	                                 Other  	 Other  	<Othr>	+++++++++	02.17.05.01.04.02.03.01.02	 [0..n]  	 	C
 9.1.16  	 	                                     Identification  	 Identification  	<Id>	++++++++++	02.17.05.01.04.02.03.01.02.01	 [1..1]  	 Text  	R
 9.1.17  	 	                                     SchemeName  	 SchemeName  	<SchmeNm>	++++++++++	02.17.05.01.04.02.03.01.02.02	 [0..1]  	 	BD
 9.1.18  	 {{Or  	                                         Code  	 Code  	<Cd>	+++++++++++	02.17.05.01.04.02.03.01.02.02	 [1..1]  	 Code  	XOR
 9.1.19  	 Or}}  	                                         Proprietary  	 Proprietary  	<Prtry>	+++++++++++	02.17.05.01.04.02.03.01.02.02	 [1..1]  	 Text  	XOR
 9.1.20  	 	                                     Issuer  	 Issuer  	<Issr>	++++++++++	02.17.05.01.04.02.03.01.02.03	 [0..1]  	 Text  	NU
 9.1.21  	 Or}  	                             PrivateIdentification  	 PrivateIdentification  	<PrvtId>	++++++++	02.17.05.01.04.02.03.02	 [1..1]  	 	XOR
 9.1.22  	 	                                 DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	+++++++++	02.17.05.01.04.02.03.02.01	 [0..1]  	 	NU
 9.1.23  	 	                                     BirthDate  	 BirthDate  	<BirthDt>	++++++++++	02.17.05.01.04.02.03.02.01.01	 [1..1]  	 DateTime  	NU
 9.1.24  	 	                                     ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	++++++++++	02.17.05.01.04.02.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                                     CityOfBirth  	 CityOfBirth  	<CityOfBirth>	++++++++++	02.17.05.01.04.02.03.02.01.03	 [1..1]  	 Text  	NU
 9.1.26  	 	                                     CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	++++++++++	02.17.05.01.04.02.03.02.01.04	 [1..1]  	 Code  	NU
 9.1.27  	 	                                 Other  	 Other  	<Othr>	+++++++++	02.17.05.01.04.02.03.02.02	 [0..n]  	 	C
 9.1.28  	 	                                     Identification  	 Identification  	<Id>	++++++++++	02.17.05.01.04.02.03.02.02.01	 [1..1]  	 Text  	R
 9.1.29  	 	                                     SchemeName  	 SchemeName  	<SchmeNm>	++++++++++	02.17.05.01.04.02.03.02.02.02	 [0..1]  	 	C
 9.1.30  	 {{Or  	                                         Code  	 Code  	<Cd>	+++++++++++	02.17.05.01.04.02.03.02.02.02	 [1..1]  	 Code  	XOR
 9.1.31  	 Or}}  	                                         Proprietary  	 Proprietary  	<Prtry>	+++++++++++	02.17.05.01.04.02.03.02.02.02	 [1..1]  	 Text  	XOR
 9.1.32  	 	                                     Issuer  	 Issuer  	<Issr>	++++++++++	02.17.05.01.04.02.03.02.02.03	 [0..1]  	 Text  	NU
 9.1.33  	 	                         CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	+++++++	02.17.05.01.04.02.04	 [0..1]  	 Code  	NU
 9.1.34  	 	                         ContactDetails  	 ContactDetails  	<CtctDtls>	+++++++	02.17.05.01.04.02.05	 [0..1]  	 	NU
 9.1.35  	 	                             NamePrefix  	 NamePrefix  	<NmPrfx>	++++++++	02.17.05.01.04.02.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                             Name  	 Name  	<Nm>	++++++++	02.17.05.01.04.02.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                             PhoneNumber  	 PhoneNumber  	<PhneNb>	++++++++	02.17.05.01.04.02.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                             MobileNumber  	 MobileNumber  	<MobNb>	++++++++	02.17.05.01.04.02.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                             FaxNumber  	 FaxNumber  	<FaxNb>	++++++++	02.17.05.01.04.02.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                             EmailAddress  	 EmailAddress  	<EmailAdr>	++++++++	02.17.05.01.04.02.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.02.05.07	 [0..1]  	 Text  	NU
 2.54  	 	                     OriginalCreditorAgent  	 OriginalCreditorAgent  	<OrgnlCdtrAgt>	++++++	02.17.05.01.04.03	 [0..1]  	   	NU
 6.1.0  		                         FinancialInstitutionIdentification  	 FinancialInstitutionIdentification  	<FinInstnId>	+++++++	02.17.05.01.04.03.01	 [1..1]  	 	NU
 6.1.1  		                             BIC  	 BIC  	<BIC>	++++++++	02.17.05.01.04.03.01.01	 [0..1]  	 Identifier  	NU
 6.1.2  		                             ClearingSystemMemberIdentification  	 ClearingSystemMemberIdentification  	<ClrSysMmbId>	++++++++	02.17.05.01.04.03.01.02	 [0..1]  	 	NU
 6.1.3  		                                 ClearingSystemIdentification  	 ClearingSystemIdentification  	<ClrSysId>	+++++++++	02.17.05.01.04.03.01.02.01	 [0..1]  	 	NU
 6.1.4  	 {Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.03.01.02.01.01	 [1..1]  	 Code  	NU
 6.1.5  	 Or}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.03.01.02.01.02	 [1..1]  	 Text  	NU
 6.1.6  	 	                                 MemberIdentification  	 MemberIdentification  	<MmbId>	+++++++++	02.17.05.01.04.03.01.02.02	 [1..1]  	 Text  	NU
 6.1.7  	 	                             Name  	 Name  	<Nm>	++++++++	02.17.05.01.04.03.01.03	 [0..1]  	 Text  	NU
 6.1.8  	 	                             PostalAddress  	 PostalAddress  	<PstlAdr>	++++++++	02.17.05.01.04.03.01.04	 [0..1]  	 	NU
 6.1.9  	 	                                 AddressType  	 AddressType  	<AdrTp>	+++++++++	02.17.05.01.04.03.01.04.01	 [0..1]  	 Code  	NU
 6.1.10  	 	                                 Department  	 Department  	<Dept>	+++++++++	02.17.05.01.04.03.01.04.02	 [0..1]  	 Text  	NU
 6.1.11  	 	                                 SubDepartment  	 SubDepartment  	<SubDept>	+++++++++	02.17.05.01.04.03.01.04.03	 [0..1]  	 Text  	NU
 6.1.12  	 	                                 StreetName  	 StreetName  	<StrtNm>	+++++++++	02.17.05.01.04.03.01.04.04	 [0..1]  	 Text  	NU
 6.1.13  	 	                                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++++++	02.17.05.01.04.03.01.04.05	 [0..1]  	 Text  	NU
 6.1.14  	 	                                 PostCode  	 PostCode  	<PstCd>	+++++++++	02.17.05.01.04.03.01.04.06	 [0..1]  	 Text  	NU
 6.1.15  	 	                                 TownName  	 TownName  	<TwnNm>	+++++++++	02.17.05.01.04.03.01.04.07	 [0..1]  	 Text  	NU
 6.1.16  	 	                                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++++++	02.17.05.01.04.03.01.04.08	 [0..1]  	 Text  	NU
 6.1.17  	 	                                 Country  	 Country  	<Ctry>	+++++++++	02.17.05.01.04.03.01.04.09	 [0..1]  	 Code  	NU
 6.1.18  	 	                                 AddressLine  	 AddressLine  	<AdrLine>	+++++++++	02.17.05.01.04.03.01.04.10	 [0..7]  	 Text  	NU
 6.1.19  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.03.01.05	 [0..1]  	 	NU
 6.1.20  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.05.01.04.03.01.05.01	 [1..1]  	 Text  	NU
 6.1.21  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.05.01.04.03.01.05.02	 [0..1]  	 	NU
 6.1.22  	 {Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.03.01.05.02.01	 [1..1]  	 Code  	NU
 6.1.23  	 Or}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.03.01.05.02.02	 [1..1]  	 Text  	NU
 6.1.24  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.05.01.04.03.01.05.03	 [0..1]  	 Text  	NU
 6.1.25  	 	                         BranchIdentification  	 BranchIdentification  	<BrnchId>	+++++++	02.17.05.01.04.03.02	 [0..1]  	 	NU
 6.1.26  	 	                             Identification  	 Identification  	<Id>	++++++++	02.17.05.01.04.03.02.01	 [0..1]  	 Text  	NU
 6.1.27  	 	                             Name  	 Name  	<Nm>	++++++++	02.17.05.01.04.03.02.02	 [0..1]  	 Text  	NU
 6.1.28  		                             PostalAddress  	 PostalAddress  	<PstlAdr>	++++++++	02.17.05.01.04.03.02.03	 [0..1]  	 	NU
 6.1.29  		                                 AddressType  	 AddressType  	<AdrTp>	+++++++++	02.17.05.01.04.03.02.03.01	 [0..1]  	 Code  	NU
 6.1.30  		                                 Department  	 Department  	<Dept>	+++++++++	02.17.05.01.04.03.02.03.02	 [0..1]  	 Text  	NU
 6.1.31  		                                 SubDepartment  	 SubDepartment  	<SubDept>	+++++++++	02.17.05.01.04.03.02.03.03	 [0..1]  	 Text  	NU
 6.1.32  		                                 StreetName  	 StreetName  	<StrtNm>	+++++++++	02.17.05.01.04.03.02.03.04	 [0..1]  	 Text  	NU
 6.1.33  		                                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++++++	02.17.05.01.04.03.02.03.05	 [0..1]  	 Text  	NU
 6.1.34  		                                 PostCode  	 PostCode  	<PstCd>	+++++++++	02.17.05.01.04.03.02.03.06	 [0..1]  	 Text  	NU
 6.1.35  		                                 TownName  	 TownName  	<TwnNm>	+++++++++	02.17.05.01.04.03.02.03.07	 [0..1]  	 Text  	NU
 6.1.36  		                                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++++++	02.17.05.01.04.03.02.03.08	 [0..1]  	 Text  	NU
 6.1.37  		                                 Country  	 Country  	<Ctry>	+++++++++	02.17.05.01.04.03.02.03.09	 [0..1]  	 Code  	NU
 6.1.38  		                                 AddressLine  	 AddressLine  	<AdrLine>	+++++++++	02.17.05.01.04.03.02.03.10	 [0..7]  	 Text  	NU
 2.55  	 	                     OriginalCreditorAgentAccount  	 OriginalCreditorAgentAccount  	<OrgnlCdtrAgtAcct>	++++++	02.17.05.01.04.04	 [0..1]  	   	NU
 1.1.0  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.05.01.04.04.01	 [1..1]  	 	NU
 1.1.1  	 {Or  	                             IBAN  	 IBAN  	<IBAN>	++++++++	02.17.05.01.04.04.01.01	 [1..1]  	 Identifier  	NU
 1.1.2  	 Or}  	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.04.01.02	 [1..1]  	 	NU
 1.1.3  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.05.01.04.04.01.02.01	 [1..1]  	 Text  	NU
 1.1.4  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.05.01.04.04.01.02.02	 [0..1]  	 	NU
 1.1.5  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.04.01.02.02.01	 [1..1]  	 Code  	NU
 1.1.6  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.04.01.02.02.02	 [1..1]  	 Text  	NU
 1.1.7  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.05.01.04.04.01.02.03	 [0..1]  	 Text  	NU
 1.1.8  	 	                         Type  	 Type  	<Tp>	+++++++	02.17.05.01.04.04.02	 [0..1]  	 	NU
 1.1.9  	 {Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.05.01.04.04.02.01	 [1..1]  	 Code  	NU
 1.1.10  	 Or}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.05.01.04.04.02.02	 [1..1]  	 Text  	NU
 1.1.11  	 	                         Currency  	 Currency  	<Ccy>	+++++++	02.17.05.01.04.04.03	 [0..1]  	 Code  	NU
 1.1.12  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.05.01.04.04.04	 [0..1]  	 Text  	NU
 2.56  	 	                     OriginalDebtor  	 OriginalDebtor  	<OrgnlDbtr>	++++++	02.17.05.01.04.05	 [0..1]  	   	BD
 9.1.0  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.05.01.04.05.01	 [0..1]  	 Text  	NU
 9.1.1  	 	                         PostalAddress  	 PostalAddress  	<PstlAdr>	+++++++	02.17.05.01.04.05.02	 [0..1]  	 	NU
 9.1.2  	 	                             AddressType  	 AddressType  	<AdrTp>	++++++++	02.17.05.01.04.05.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                             Department  	 Department  	<Dept>	++++++++	02.17.05.01.04.05.02.02	 [0..1]  	 Text  	NU
 9.1.4  	 	                             SubDepartment  	 SubDepartment  	<SubDept>	++++++++	02.17.05.01.04.05.02.03	 [0..1]  	 Text  	NU
 9.1.5  	 	                             StreetName  	 StreetName  	<StrtNm>	++++++++	02.17.05.01.04.05.02.04	 [0..1]  	 Text  	NU
 9.1.6  	 	                             BuildingNumber  	 BuildingNumber  	<BldgNb>	++++++++	02.17.05.01.04.05.02.05	 [0..1]  	 Text  	NU
 9.1.7  	 	                             PostCode  	 PostCode  	<PstCd>	++++++++	02.17.05.01.04.05.02.06	 [0..1]  	 Text  	NU
 9.1.8  	 	                             TownName  	 TownName  	<TwnNm>	++++++++	02.17.05.01.04.05.02.07	 [0..1]  	 Text  	NU
 9.1.9  	 	                             CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++++++	02.17.05.01.04.05.02.08	 [0..1]  	 Text  	NU
 9.1.10  	 	                             Country  	 Country  	<Ctry>	++++++++	02.17.05.01.04.05.02.09	 [0..1]  	 Code  	NU
 9.1.11  	 	                             AddressLine  	 AddressLine  	<AdrLine>	++++++++	02.17.05.01.04.05.02.10	 [0..7]  	 Text  	NU
 9.1.12  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.05.01.04.05.03	 [0..1]  	 	C
 9.1.13  	 {Or  	                             OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	++++++++	02.17.05.01.04.05.03.01	 [1..1]  	 	XOR
 9.1.14  	 	                                 BICOrBEI  	 BICOrBEI  	<BICOrBEI>	+++++++++	02.17.05.01.04.05.03.01.01	 [0..1]  	 Identifier  	C
 9.1.15  	 	                                 Other  	 Other  	<Othr>	+++++++++	02.17.05.01.04.05.03.01.02	 [0..n]  	 	C
 9.1.16  	 	                                     Identification  	 Identification  	<Id>	++++++++++	02.17.05.01.04.05.03.01.02.01	 [1..1]  	 Text  	R
 9.1.17  	 	                                     SchemeName  	 SchemeName  	<SchmeNm>	++++++++++	02.17.05.01.04.05.03.01.02.02	 [0..1]  	 	BD
 9.1.18  	 {{Or  	                                         Code  	 Code  	<Cd>	+++++++++++	02.17.05.01.04.05.03.01.02.02	 [1..1]  	 Code  	XOR
 9.1.19  	 Or}}  	                                         Proprietary  	 Proprietary  	<Prtry>	+++++++++++	02.17.05.01.04.05.03.01.02.02	 [1..1]  	 Text  	XOR
 9.1.20  	 	                                     Issuer  	 Issuer  	<Issr>	++++++++++	02.17.05.01.04.05.03.01.02.03	 [0..1]  	 Text  	BD
 9.1.21  	 Or}  	                             PrivateIdentification  	 PrivateIdentification  	<PrvtId>	++++++++	02.17.05.01.04.05.03.02	 [1..1]  	 	XOR
 9.1.22  	 	                                 DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	+++++++++	02.17.05.01.04.05.03.02.01	 [0..1]  	 	NU
 9.1.23  	 	                                     BirthDate  	 BirthDate  	<BirthDt>	++++++++++	02.17.05.01.04.05.03.02.01.01	 [1..1]  	 DateTime  	NU
 9.1.24  	 	                                     ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	++++++++++	02.17.05.01.04.05.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                                     CityOfBirth  	 CityOfBirth  	<CityOfBirth>	++++++++++	02.17.05.01.04.05.03.02.01.03	 [1..1]  	 Text  	NU
 9.1.26  	 	                                     CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	++++++++++	02.17.05.01.04.05.03.02.01.04	 [1..1]  	 Code  	NU
 9.1.27  	 	                                 Other  	 Other  	<Othr>	+++++++++	02.17.05.01.04.05.03.02.02	 [0..n]  	 	BD
 9.1.28  	 	                                     Identification  	 Identification  	<Id>	++++++++++	02.17.05.01.04.05.03.02.02.01	 [1..1]  	 Text  	BD
 9.1.29  	 	                                     SchemeName  	 SchemeName  	<SchmeNm>	++++++++++	02.17.05.01.04.05.03.02.02.02	 [0..1]  	 	BD
 9.1.30  	 {{Or  	                                         Code  	 Code  	<Cd>	+++++++++++	02.17.05.01.04.05.03.02.02.02	 [1..1]  	 Code  	BD
 9.1.31  	 Or}}  	                                         Proprietary  	 Proprietary  	<Prtry>	+++++++++++	02.17.05.01.04.05.03.02.02.02	 [1..1]  	 Text  	NU
 9.1.32  	 	                                     Issuer  	 Issuer  	<Issr>	++++++++++	02.17.05.01.04.05.03.02.02.03	 [0..1]  	 Text  	NU
 9.1.33  	 	                         CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	+++++++	02.17.05.01.04.05.04	 [0..1]  	 Code  	C
 9.1.34  	 	                         ContactDetails  	 ContactDetails  	<CtctDtls>	+++++++	02.17.05.01.04.05.05	 [0..1]  	 	NU
 9.1.35  	 	                             NamePrefix  	 NamePrefix  	<NmPrfx>	++++++++	02.17.05.01.04.05.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                             Name  	 Name  	<Nm>	++++++++	02.17.05.01.04.05.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                             PhoneNumber  	 PhoneNumber  	<PhneNb>	++++++++	02.17.05.01.04.05.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                             MobileNumber  	 MobileNumber  	<MobNb>	++++++++	02.17.05.01.04.05.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                             FaxNumber  	 FaxNumber  	<FaxNb>	++++++++	02.17.05.01.04.05.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                             EmailAddress  	 EmailAddress  	<EmailAdr>	++++++++	02.17.05.01.04.05.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.05.05.07	 [0..1]  	 Text  	NU
 2.57  	 	                     OriginalDebtorAccount  	 OriginalDebtorAccount  	<OrgnlDbtrAcct>	++++++	02.17.05.01.04.06	 [0..1]  	   	C
 1.1.0  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.05.01.04.06.01	 [1..1]  	 	C
 1.1.1  	 {Or  	                             IBAN  	 IBAN  	<IBAN>	++++++++	02.17.05.01.04.06.01.01	 [1..1]  	 Identifier  	R
 1.1.2  	 Or}  	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.06.01.02	 [1..1]  	 	NU
 1.1.3  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.05.01.04.06.01.02.01	 [1..1]  	 Text  	NU
 1.1.4  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.05.01.04.06.01.02.02	 [0..1]  	 	NU
 1.1.5  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.06.01.02.02.01	 [1..1]  	 Code  	NU
 1.1.6  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.06.01.02.02.02	 [1..1]  	 Text  	NU
 1.1.7  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.05.01.04.06.01.02.03	 [0..1]  	 Text  	NU
 1.1.8  	 	                         Type  	 Type  	<Tp>	+++++++	02.17.05.01.04.06.02	 [0..1]  	 	NU
 1.1.9  	 {Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.05.01.04.06.02.01	 [1..1]  	 Code  	NU
 1.1.10  	 Or}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.05.01.04.06.02.02	 [1..1]  	 Text  	NU
 1.1.11  	 	                         Currency  	 Currency  	<Ccy>	+++++++	02.17.05.01.04.06.03	 [0..1]  	 Code  	NU
 1.1.12  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.05.01.04.06.04	 [0..1]  	 Text  	NU
 2.58  	 	                     OriginalDebtorAgent  	 OriginalDebtorAgent  	<OrgnlDbtrAgt>	++++++	02.17.05.01.04.07	 [0..1]  	   	C
 6.1.0  		                         FinancialInstitutionIdentification  	 FinancialInstitutionIdentification  	<FinInstnId>	+++++++	02.17.05.01.04.07.01	 [1..1]  	 	R
 6.1.1  		                             BIC  	 BIC  	<BIC>	++++++++	02.17.05.01.04.07.01.01	 [0..1]  	 Identifier  	BD
 6.1.2  		                             ClearingSystemMemberIdentification  	 ClearingSystemMemberIdentification  	<ClrSysMmbId>	++++++++	02.17.05.01.04.07.01.02	 [0..1]  	 	NU
 6.1.3  		                                 ClearingSystemIdentification  	 ClearingSystemIdentification  	<ClrSysId>	+++++++++	02.17.05.01.04.07.01.02.01	 [0..1]  	 	NU
 6.1.4  	 {Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.07.01.02.01.01	 [1..1]  	 Code  	NU
 6.1.5  	 Or}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.07.01.02.01.02	 [1..1]  	 Text  	NU
 6.1.6  	 	                                 MemberIdentification  	 MemberIdentification  	<MmbId>	+++++++++	02.17.05.01.04.07.01.02.02	 [1..1]  	 Text  	NU
 6.1.7  	 	                             Name  	 Name  	<Nm>	++++++++	02.17.05.01.04.07.01.03	 [0..1]  	 Text  	NU
 6.1.8  	 	                             PostalAddress  	 PostalAddress  	<PstlAdr>	++++++++	02.17.05.01.04.07.01.04	 [0..1]  	 	NU
 6.1.9  	 	                                 AddressType  	 AddressType  	<AdrTp>	+++++++++	02.17.05.01.04.07.01.04.01	 [0..1]  	 Code  	NU
 6.1.10  	 	                                 Department  	 Department  	<Dept>	+++++++++	02.17.05.01.04.07.01.04.02	 [0..1]  	 Text  	NU
 6.1.11  	 	                                 SubDepartment  	 SubDepartment  	<SubDept>	+++++++++	02.17.05.01.04.07.01.04.03	 [0..1]  	 Text  	NU
 6.1.12  	 	                                 StreetName  	 StreetName  	<StrtNm>	+++++++++	02.17.05.01.04.07.01.04.04	 [0..1]  	 Text  	NU
 6.1.13  	 	                                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++++++	02.17.05.01.04.07.01.04.05	 [0..1]  	 Text  	NU
 6.1.14  	 	                                 PostCode  	 PostCode  	<PstCd>	+++++++++	02.17.05.01.04.07.01.04.06	 [0..1]  	 Text  	NU
 6.1.15  	 	                                 TownName  	 TownName  	<TwnNm>	+++++++++	02.17.05.01.04.07.01.04.07	 [0..1]  	 Text  	NU
 6.1.16  	 	                                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++++++	02.17.05.01.04.07.01.04.08	 [0..1]  	 Text  	NU
 6.1.17  	 	                                 Country  	 Country  	<Ctry>	+++++++++	02.17.05.01.04.07.01.04.09	 [0..1]  	 Code  	NU
 6.1.18  	 	                                 AddressLine  	 AddressLine  	<AdrLine>	+++++++++	02.17.05.01.04.07.01.04.10	 [0..7]  	 Text  	NU
 6.1.19  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.07.01.05	 [0..1]  	 	C
 6.1.20  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.05.01.04.07.01.05.01	 [1..1]  	 Text  	R
 6.1.21  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.05.01.04.07.01.05.02	 [0..1]  	 	R
 6.1.22  	 {Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.07.01.05.02.01	 [1..1]  	 Code  	NU
 6.1.23  	 Or}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.07.01.05.02.02	 [1..1]  	 Text  	R
 6.1.24  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.05.01.04.07.01.05.03	 [0..1]  	 Text  	NU
 6.1.25  	 	                         BranchIdentification  	 BranchIdentification  	<BrnchId>	+++++++	02.17.05.01.04.07.02	 [0..1]  	 	NU
 6.1.26  	 	                             Identification  	 Identification  	<Id>	++++++++	02.17.05.01.04.07.02.01	 [0..1]  	 Text  	NU
 6.1.27  	 	                             Name  	 Name  	<Nm>	++++++++	02.17.05.01.04.07.02.02	 [0..1]  	 Text  	NU
 6.1.28  		                             PostalAddress  	 PostalAddress  	<PstlAdr>	++++++++	02.17.05.01.04.07.02.03	 [0..1]  	 	NU
 6.1.29  		                                 AddressType  	 AddressType  	<AdrTp>	+++++++++	02.17.05.01.04.07.02.03.01	 [0..1]  	 Code  	NU
 6.1.30  		                                 Department  	 Department  	<Dept>	+++++++++	02.17.05.01.04.07.02.03.02	 [0..1]  	 Text  	NU
 6.1.31  		                                 SubDepartment  	 SubDepartment  	<SubDept>	+++++++++	02.17.05.01.04.07.02.03.03	 [0..1]  	 Text  	NU
 6.1.32  		                                 StreetName  	 StreetName  	<StrtNm>	+++++++++	02.17.05.01.04.07.02.03.04	 [0..1]  	 Text  	NU
 6.1.33  		                                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++++++	02.17.05.01.04.07.02.03.05	 [0..1]  	 Text  	NU
 6.1.34  		                                 PostCode  	 PostCode  	<PstCd>	+++++++++	02.17.05.01.04.07.02.03.06	 [0..1]  	 Text  	NU
 6.1.35  		                                 TownName  	 TownName  	<TwnNm>	+++++++++	02.17.05.01.04.07.02.03.07	 [0..1]  	 Text  	NU
 6.1.36  		                                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++++++	02.17.05.01.04.07.02.03.08	 [0..1]  	 Text  	NU
 6.1.37  		                                 Country  	 Country  	<Ctry>	+++++++++	02.17.05.01.04.07.02.03.09	 [0..1]  	 Code  	NU
 6.1.38  		                                 AddressLine  	 AddressLine  	<AdrLine>	+++++++++	02.17.05.01.04.07.02.03.10	 [0..7]  	 Text  	NU
 2.59  	 	                     OriginalDebtorAgentAccount  	 OriginalDebtorAgentAccount  	<OrgnlDbtrAgtAcct>	++++++	02.17.05.01.04.08	 [0..1]  	   	NU
 1.1.0  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.05.01.04.08.01	 [1..1]  	 	NU
 1.1.1  	 {Or  	                             IBAN  	 IBAN  	<IBAN>	++++++++	02.17.05.01.04.08.01.01	 [1..1]  	 Identifier  	NU
 1.1.2  	 Or}  	                             Other  	 Other  	<Othr>	++++++++	02.17.05.01.04.08.01.02	 [1..1]  	 	NU
 1.1.3  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.05.01.04.08.01.02.01	 [1..1]  	 Text  	NU
 1.1.4  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.05.01.04.08.01.02.02	 [0..1]  	 	NU
 1.1.5  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.05.01.04.08.01.02.02.01	 [1..1]  	 Code  	NU
 1.1.6  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.05.01.04.08.01.02.02.02	 [1..1]  	 Text  	NU
 1.1.7  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.05.01.04.08.01.02.03	 [0..1]  	 Text  	NU
 1.1.8  	 	                         Type  	 Type  	<Tp>	+++++++	02.17.05.01.04.08.02	 [0..1]  	 	NU
 1.1.9  	 {Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.05.01.04.08.02.01	 [1..1]  	 Code  	NU
 1.1.10  	 Or}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.05.01.04.08.02.02	 [1..1]  	 Text  	NU
 1.1.11  	 	                         Currency  	 Currency  	<Ccy>	+++++++	02.17.05.01.04.08.03	 [0..1]  	 Code  	NU
 1.1.12  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.05.01.04.08.04	 [0..1]  	 Text  	NU
 2.60  	 	                     OriginalFinalCollectionDate  	 OriginalFinalCollectionDate  	<OrgnlFnlColltnDt>	++++++	02.17.05.01.04.09	 [0..1]  	 DateTime  	NU
 2.61  	 	                     OriginalFrequency  	 OriginalFrequency  	<OrgnlFrqcy>	++++++	02.17.05.01.04.10	 [0..1]  	 Code  	NU
 2.62  	 	                 ElectronicSignature  	 ElectronicSignature  	<ElctrncSgntr>	+++++	02.17.05.01.05	 [0..1]  	 Text  	BD
 2.63  	 	                 FirstCollectionDate  	 FirstCollectionDate  	<FrstColltnDt>	+++++	02.17.05.01.06	 [0..1]  	 DateTime  	BD
 2.64  	 	                 FinalCollectionDate  	 FinalCollectionDate  	<FnlColltnDt>	+++++	02.17.05.01.07	 [0..1]  	 DateTime  	BD
 2.65  	 	                 Frequency  	 Frequency  	<Frqcy>	+++++	02.17.05.01.08	 [0..1]  	 Code  	BD
 2.66  	 	             CreditorSchemeIdentification  	 CreditorSchemeIdentification  	<CdtrSchmeId>	++++	02.17.05.02	 [0..1]  	   	C
 9.1.0  	 	                 Name  	 Name  	<Nm>	+++++	02.17.05.02.01	 [0..1]  	 Text  	BD
 9.1.1  	 	                 PostalAddress  	 PostalAddress  	<PstlAdr>	+++++	02.17.05.02.02	 [0..1]  	 	NU
 9.1.2  	 	                     AddressType  	 AddressType  	<AdrTp>	++++++	02.17.05.02.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                     Department  	 Department  	<Dept>	++++++	02.17.05.02.02.02	 [0..1]  	 Text  	NU
 9.1.4  	 	                     SubDepartment  	 SubDepartment  	<SubDept>	++++++	02.17.05.02.02.03	 [0..1]  	 Text  	NU
 9.1.5  	 	                     StreetName  	 StreetName  	<StrtNm>	++++++	02.17.05.02.02.04	 [0..1]  	 Text  	NU
 9.1.6  	 	                     BuildingNumber  	 BuildingNumber  	<BldgNb>	++++++	02.17.05.02.02.05	 [0..1]  	 Text  	NU
 9.1.7  	 	                     PostCode  	 PostCode  	<PstCd>	++++++	02.17.05.02.02.06	 [0..1]  	 Text  	NU
 9.1.8  	 	                     TownName  	 TownName  	<TwnNm>	++++++	02.17.05.02.02.07	 [0..1]  	 Text  	NU
 9.1.9  	 	                     CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++++	02.17.05.02.02.08	 [0..1]  	 Text  	NU
 9.1.10  	 	                     Country  	 Country  	<Ctry>	++++++	02.17.05.02.02.09	 [0..1]  	 Code  	NU
 9.1.11  	 	                     AddressLine  	 AddressLine  	<AdrLine>	++++++	02.17.05.02.02.10	 [0..7]  	 Text  	NU
 9.1.12  	 	                 Identification  	 Identification  	<Id>	+++++	02.17.05.02.03	 [0..1]  	 	C
 9.1.13  	 {Or  	                     OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	++++++	02.17.05.02.03.01	 [1..1]  	 	XOR
 9.1.14  	 	                         BICOrBEI  	 BICOrBEI  	<BICOrBEI>	+++++++	02.17.05.02.03.01.01	 [0..1]  	 Identifier  	C
 9.1.15  	 	                         Other  	 Other  	<Othr>	+++++++	02.17.05.02.03.01.02	 [0..n]  	 	C
 9.1.16  	 	                             Identification  	 Identification  	<Id>	++++++++	02.17.05.02.03.01.02.01	 [1..1]  	 Text  	R
 9.1.17  	 	                             SchemeName  	 SchemeName  	<SchmeNm>	++++++++	02.17.05.02.03.01.02.02	 [0..1]  	 	BD
 9.1.18  	 {{Or  	                                 Code  	 Code  	<Cd>	+++++++++	02.17.05.02.03.01.02.02.01	 [1..1]  	 Code  	XOR
 9.1.19  	 Or}}  	                                 Proprietary  	 Proprietary  	<Prtry>	+++++++++	02.17.05.02.03.01.02.02.02	 [1..1]  	 Text  	XOR
 9.1.20  	 	                             Issuer  	 Issuer  	<Issr>	++++++++	02.17.05.02.03.01.02.03	 [0..1]  	 Text  	NU
 9.1.21  	 Or}  	                     PrivateIdentification  	 PrivateIdentification  	<PrvtId>	++++++	02.17.05.02.03.02	 [1..1]  	 	XOR
 9.1.22  	 	                         DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	+++++++	02.17.05.02.03.02.01	 [0..1]  	 	NU
 9.1.23  	 	                             BirthDate  	 BirthDate  	<BirthDt>	++++++++	02.17.05.02.03.02.01.01	 [1..1]  	 DateTime  	NU
 9.1.24  	 	                             ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	++++++++	02.17.05.02.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                             CityOfBirth  	 CityOfBirth  	<CityOfBirth>	++++++++	02.17.05.02.03.02.01.03	 [1..1]  	 Text  	NU
 9.1.26  	 	                             CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	++++++++	02.17.05.02.03.02.01.04	 [1..1]  	 Code  	NU
 9.1.27  	 	                         Other  	 Other  	<Othr>	+++++++	02.17.05.02.03.02.02	 [0..n]  	 	C
 9.1.28  	 	                             Identification  	 Identification  	<Id>	++++++++	02.17.05.02.03.02.02.01	 [1..1]  	 Text  	R
 9.1.29  	 	                             SchemeName  	 SchemeName  	<SchmeNm>	++++++++	02.17.05.02.03.02.02.02	 [0..1]  	 	C
 9.1.30  	 {{Or  	                                 Code  	 Code  	<Cd>	+++++++++	02.17.05.02.03.02.02.02.01	 [1..1]  	 Code  	XOR
 9.1.31  	 Or}}  	                                 Proprietary  	 Proprietary  	<Prtry>	+++++++++	02.17.05.02.03.02.02.02.02	 [1..1]  	 Text  	XOR
 9.1.32  	 	                             Issuer  	 Issuer  	<Issr>	++++++++	02.17.05.02.03.02.02.03	 [0..1]  	 Text  	NU
 9.1.33  	 	                 CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	+++++	02.17.05.02.04	 [0..1]  	 Code  	NU
 9.1.34  	 	                 ContactDetails  	 ContactDetails  	<CtctDtls>	+++++	02.17.05.02.05	 [0..1]  	 	NU
 9.1.35  	 	                     NamePrefix  	 NamePrefix  	<NmPrfx>	++++++	02.17.05.02.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                     Name  	 Name  	<Nm>	++++++	02.17.05.02.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                     PhoneNumber  	 PhoneNumber  	<PhneNb>	++++++	02.17.05.02.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                     MobileNumber  	 MobileNumber  	<MobNb>	++++++	02.17.05.02.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                     FaxNumber  	 FaxNumber  	<FaxNb>	++++++	02.17.05.02.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                     EmailAddress  	 EmailAddress  	<EmailAdr>	++++++	02.17.05.02.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                     Other  	 Other  	<Othr>	++++++	02.17.05.02.05.07	 [0..1]  	 Text  	NU
 2.67  	 	             PreNotificationIdentification  	 PreNotificationIdentification  	<PreNtfctnId>	++++	02.17.05.03	 [0..1]  	 Text  	BD
 2.68  	 	             PreNotificationDate  	 PreNotificationDate  	<PreNtfctnDt>	++++	02.17.05.04	 [0..1]  	 DateTime  	BD
 2.69  	 	         UltimateCreditor  	 UltimateCreditor  	<UltmtCdtr>	+++	02.17.06	 [0..1]  		C
 9.1.0  	 	             Name  	 Name  	<Nm>	++++	02.17.06.01	 [0..1]  	 Text  	R
 9.1.1  	 	             PostalAddress  	 PostalAddress  	<PstlAdr>	++++	02.17.06.02	 [0..1]  	 	C
 9.1.2  	 	                 AddressType  	 AddressType  	<AdrTp>	+++++	02.17.06.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                 Department  	 Department  	<Dept>	+++++	02.17.06.02.02	 [0..1]  	 Text  	BD
 9.1.4  	 	                 SubDepartment  	 SubDepartment  	<SubDept>	+++++	02.17.06.02.03	 [0..1]  	 Text  	BD
 9.1.5  	 	                 StreetName  	 StreetName  	<StrtNm>	+++++	02.17.06.02.04	 [0..1]  	 Text  	BD
 9.1.6  	 	                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++	02.17.06.02.05	 [0..1]  	 Text  	BD
 9.1.7  	 	                 PostCode  	 PostCode  	<PstCd>	+++++	02.17.06.02.06	 [0..1]  	 Text  	BD
 9.1.8  	 	                 TownName  	 TownName  	<TwnNm>	+++++	02.17.06.02.07	 [0..1]  	 Text  	BD
 9.1.9  	 	                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++	02.17.06.02.08	 [0..1]  	 Text  	BD
 9.1.10  	 	                 Country  	 Country  	<Ctry>	+++++	02.17.06.02.09	 [0..1]  	 Code  	R
 9.1.11  	 	                 AddressLine  	 AddressLine  	<AdrLine>	+++++	02.17.06.02.10	 [0..7]  	 Text  	BD
 9.1.12  	 	             Identification  	 Identification  	<Id>	++++	02.17.06.03	 [0..1]  	 	C
 9.1.13  	 {Or  	                 OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	+++++	02.17.06.03.01	 [1..1]  	 	R
 9.1.14  	 	                     BICOrBEI  	 BICOrBEI  	<BICOrBEI>	++++++	02.17.06.03.01.01	 [0..1]  	 Identifier  	C
 9.1.15  	 	                     Other  	 Other  	<Othr>	++++++	02.17.06.03.01.02	 [0..n]  	 	C
 9.1.16  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.06.03.01.02.01	 [1..1]  	 Text  	R
 9.1.17  	 	                         SchemeName  	 SchemeName  	<SchmeNm>	+++++++	02.17.06.03.01.02.02	 [0..1]  	 	BD
 9.1.18  	 {{Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.06.03.01.02.02.01	 [1..1]  	 Code  	XOR
 9.1.19  	 Or}}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.06.03.01.02.02.02	 [1..1]  	 Text  	XOR
 9.1.20  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.06.03.01.02.03	 [0..1]  	 Text  	NU
 9.1.21  	 Or}  	                 PrivateIdentification  	 PrivateIdentification  	<PrvtId>	+++++	02.17.06.03.02	 [1..1]  	 	NU
 9.1.22  	 	                     DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	++++++	02.17.06.03.02.01	 [0..1]  	 	NU
 9.1.23  	 	                         BirthDate  	 BirthDate  	<BirthDt>	+++++++	02.17.06.03.02.01.01	 [1..1]  	 DateTime  	NU
 9.1.24  	 	                         ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	+++++++	02.17.06.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                         CityOfBirth  	 CityOfBirth  	<CityOfBirth>	+++++++	02.17.06.03.02.01.03	 [1..1]  	 Text  	NU
 9.1.26  	 	                         CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	+++++++	02.17.06.03.02.01.04	 [1..1]  	 Code  	NU
 9.1.27  	 	                     Other  	 Other  	<Othr>	++++++	02.17.06.03.02.02	 [0..n]  	 	NU
 9.1.28  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.06.03.02.02.01	 [1..1]  	 Text  	NU
 9.1.29  	 	                         SchemeName  	 SchemeName  	<SchmeNm>	+++++++	02.17.06.03.02.02.02	 [0..1]  	 	NU
 9.1.30  	 {{Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.06.03.02.02.02.01	 [1..1]  	 Code  	NU
 9.1.31  	 Or}}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.06.03.02.02.02.02	 [1..1]  	 Text  	NU
 9.1.32  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.06.03.02.02.03	 [0..1]  	 Text  	NU
 9.1.33  	 	             CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	++++	02.17.06.04	 [0..1]  	 Code  	C
 9.1.34  	 	             ContactDetails  	 ContactDetails  	<CtctDtls>	++++	02.17.06.05	 [0..1]  	 	BD
 9.1.35  	 	                 NamePrefix  	 NamePrefix  	<NmPrfx>	+++++	02.17.06.05.01	 [0..1]  	 Code  	BD
 9.1.36  	 	                 Name  	 Name  	<Nm>	+++++	02.17.06.05.02	 [0..1]  	 Text  	BD
 9.1.37  	 	                 PhoneNumber  	 PhoneNumber  	<PhneNb>	+++++	02.17.06.05.03	 [0..1]  	 Text  	BD
 9.1.38  	 	                 MobileNumber  	 MobileNumber  	<MobNb>	+++++	02.17.06.05.04	 [0..1]  	 Text  	BD
 9.1.39  	 	                 FaxNumber  	 FaxNumber  	<FaxNb>	+++++	02.17.06.05.05	 [0..1]  	 Text  	BD
 9.1.40  	 	                 EmailAddress  	 EmailAddress  	<EmailAdr>	+++++	02.17.06.05.06	 [0..1]  	 Text  	BD
 9.1.41  	 	                 Other  	 Other  	<Othr>	+++++	02.17.06.05.07	 [0..1]  	 Text  	BD
 2.70  	 	         DebtorAgent  	 DebtorAgent  	<DbtrAgt>	+++	02.17.07	 [1..1]  	   	R
 6.1.0  		             FinancialInstitutionIdentification  	 FinancialInstitutionIdentification  	<FinInstnId>	++++	02.17.07.01	 [1..1]  	 	R
 6.1.1  		                 BIC  	 BIC  	<BIC>	+++++	02.17.07.01.01	 [0..1]  	 Identifier  	C
 6.1.2  		                 ClearingSystemMemberIdentification  	 ClearingSystemMemberIdentification  	<ClrSysMmbId>	+++++	02.17.07.01.02	 [0..1]  	 	C
 6.1.3  		                     ClearingSystemIdentification  	 ClearingSystemIdentification  	<ClrSysId>	++++++	02.17.07.01.02.01	 [0..1]  	 	BD
 6.1.4  	 {Or  	                         Code  	 Code  	<Cd>	+++++++	02.17.07.01.02.01.01	 [1..1]  	 Code  	XOR
 6.1.5  	 Or}  	                         Proprietary  	 Proprietary  	<Prtry>	+++++++	02.17.07.01.02.01.02	 [1..1]  	 Text  	XOR
 6.1.6  	 	                     MemberIdentification  	 MemberIdentification  	<MmbId>	++++++	02.17.07.01.02.02	 [1..1]  	 Text  	R
 6.1.7  	 	                 Name  	 Name  	<Nm>	+++++	02.17.07.01.03	 [0..1]  	 Text  	NU
 6.1.8  	 	                 PostalAddress  	 PostalAddress  	<PstlAdr>	+++++	02.17.07.01.04	 [0..1]  	 	R
 6.1.9  	 	                     AddressType  	 AddressType  	<AdrTp>	++++++	02.17.07.01.04.01	 [0..1]  	 Code  	NU
 6.1.10  	 	                     Department  	 Department  	<Dept>	++++++	02.17.07.01.04.02	 [0..1]  	 Text  	NU
 6.1.11  	 	                     SubDepartment  	 SubDepartment  	<SubDept>	++++++	02.17.07.01.04.03	 [0..1]  	 Text  	NU
 6.1.12  	 	                     StreetName  	 StreetName  	<StrtNm>	++++++	02.17.07.01.04.04	 [0..1]  	 Text  	NU
 6.1.13  	 	                     BuildingNumber  	 BuildingNumber  	<BldgNb>	++++++	02.17.07.01.04.05	 [0..1]  	 Text  	NU
 6.1.14  	 	                     PostCode  	 PostCode  	<PstCd>	++++++	02.17.07.01.04.06	 [0..1]  	 Text  	NU
 6.1.15  	 	                     TownName  	 TownName  	<TwnNm>	++++++	02.17.07.01.04.07	 [0..1]  	 Text  	NU
 6.1.16  	 	                     CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++++	02.17.07.01.04.08	 [0..1]  	 Text  	NU
 6.1.17  	 	                     Country  	 Country  	<Ctry>	++++++	02.17.07.01.04.09	 [0..1]  	 Code  	R
 6.1.18  	 	                     AddressLine  	 AddressLine  	<AdrLine>	++++++	02.17.07.01.04.10	 [0..7]  	 Text  	NU
 6.1.19  	 	                 Other  	 Other  	<Othr>	+++++	02.17.07.01.05	 [0..1]  	 	NU
 6.1.20  	 	                     Identification  	 Identification  	<Id>	++++++	02.17.07.01.05.01	 [1..1]  	 Text  	NU
 6.1.21  	 	                     SchemeName  	 SchemeName  	<SchmeNm>	++++++	02.17.07.01.05.02	 [0..1]  	 	NU
 6.1.22  	 {Or  	                         Code  	 Code  	<Cd>	+++++++	02.17.07.01.05.02.01	 [1..1]  	 Code  	NU
 6.1.23  	 Or}  	                         Proprietary  	 Proprietary  	<Prtry>	+++++++	02.17.07.01.05.02.02	 [1..1]  	 Text  	NU
 6.1.24  	 	                     Issuer  	 Issuer  	<Issr>	++++++	02.17.07.01.05.03	 [0..1]  	 Text  	NU
 6.1.25  	 	             BranchIdentification  	 BranchIdentification  	<BrnchId>	++++	02.17.07.02	 [0..1]  	 	C
 6.1.26  	 	                 Identification  	 Identification  	<Id>	+++++	02.17.07.02.01	 [0..1]  	 Text  	BD
 6.1.27  	 	                 Name  	 Name  	<Nm>	+++++	02.17.07.02.02	 [0..1]  	 Text  	NU
 6.1.28  		                 PostalAddress  	 PostalAddress  	<PstlAdr>	+++++	02.17.07.02.03	 [0..1]  	 	NU
 6.1.29  		                     AddressType  	 AddressType  	<AdrTp>	++++++	02.17.07.02.03.01	 [0..1]  	 Code  	NU
 6.1.30  		                     Department  	 Department  	<Dept>	++++++	02.17.07.02.03.02	 [0..1]  	 Text  	NU
 6.1.31  		                     SubDepartment  	 SubDepartment  	<SubDept>	++++++	02.17.07.02.03.03	 [0..1]  	 Text  	NU
 6.1.32  		                     StreetName  	 StreetName  	<StrtNm>	++++++	02.17.07.02.03.04	 [0..1]  	 Text  	NU
 6.1.33  		                     BuildingNumber  	 BuildingNumber  	<BldgNb>	++++++	02.17.07.02.03.05	 [0..1]  	 Text  	NU
 6.1.34  		                     PostCode  	 PostCode  	<PstCd>	++++++	02.17.07.02.03.06	 [0..1]  	 Text  	NU
 6.1.35  		                     TownName  	 TownName  	<TwnNm>	++++++	02.17.07.02.03.07	 [0..1]  	 Text  	NU
 6.1.36  		                     CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++++	02.17.07.02.03.08	 [0..1]  	 Text  	NU
 6.1.37  		                     Country  	 Country  	<Ctry>	++++++	02.17.07.02.03.09	 [0..1]  	 Code  	NU
 6.1.38  		                     AddressLine  	 AddressLine  	<AdrLine>	++++++	02.17.07.02.03.10	 [0..7]  	 Text  	NU
 2.71  	 	         DebtorAgentAccount  	 DebtorAgentAccount  	<DbtrAgtAcct>	+++	02.17.08	 [0..1]  	   	NU
 1.1.0  	 	             Identification  	 Identification  	<Id>	++++	02.17.08.01	 [1..1]  	 	NU
 1.1.1  	 {Or  	                 IBAN  	 IBAN  	<IBAN>	+++++	02.17.08.01.01	 [1..1]  	 Identifier  	NU
 1.1.2  	 Or}  	                 Other  	 Other  	<Othr>	+++++	02.17.08.01.02	 [1..1]  	 	NU
 1.1.3  	 	                     Identification  	 Identification  	<Id>	++++++	02.17.08.01.02.01	 [1..1]  	 Text  	NU
 1.1.4  	 	                     SchemeName  	 SchemeName  	<SchmeNm>	++++++	02.17.08.01.02.02	 [0..1]  	 	NU
 1.1.5  	 {{Or  	                         Code  	 Code  	<Cd>	+++++++	02.17.08.01.02.02.01	 [1..1]  	 Code  	NU
 1.1.6  	 Or}}  	                         Proprietary  	 Proprietary  	<Prtry>	+++++++	02.17.08.01.02.02.02	 [1..1]  	 Text  	NU
 1.1.7  	 	                     Issuer  	 Issuer  	<Issr>	++++++	02.17.08.01.02.03	 [0..1]  	 Text  	NU
 1.1.8  	 	             Type  	 Type  	<Tp>	++++	02.17.08.02	 [0..1]  	 	NU
 1.1.9  	 {Or  	                 Code  	 Code  	<Cd>	+++++	02.17.08.02.01	 [1..1]  	 Code  	NU
 1.1.10  	 Or}  	                 Proprietary  	 Proprietary  	<Prtry>	+++++	02.17.08.02.02	 [1..1]  	 Text  	NU
 1.1.11  	 	             Currency  	 Currency  	<Ccy>	++++	02.17.08.03	 [0..1]  	 Code  	NU
 1.1.12  	 	             Name  	 Name  	<Nm>	++++	02.17.08.04	 [0..1]  	 Text  	NU
 2.72  	 	         Debtor  	 Debtor  	<Dbtr>	+++	02.17.09	 [1..1]  	   	R
 9.1.0  	 	             Name  	 Name  	<Nm>	++++	02.17.09.01	 [0..1]  	 Text  	R
 9.1.1  	 	             PostalAddress  	 PostalAddress  	<PstlAdr>	++++	02.17.09.02	 [0..1]  	 	R
 9.1.2  	 	                 AddressType  	 AddressType  	<AdrTp>	+++++	02.17.09.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                 Department  	 Department  	<Dept>	+++++	02.17.09.02.02	 [0..1]  	 Text  	BD
 9.1.4  	 	                 SubDepartment  	 SubDepartment  	<SubDept>	+++++	02.17.09.02.03	 [0..1]  	 Text  	BD
 9.1.5  	 	                 StreetName  	 StreetName  	<StrtNm>	+++++	02.17.09.02.04	 [0..1]  	 Text  	BD
 9.1.6  	 	                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++	02.17.09.02.05	 [0..1]  	 Text  	BD
 9.1.7  	 	                 PostCode  	 PostCode  	<PstCd>	+++++	02.17.09.02.06	 [0..1]  	 Text  	BD
 9.1.8  	 	                 TownName  	 TownName  	<TwnNm>	+++++	02.17.09.02.07	 [0..1]  	 Text  	BD
 9.1.9  	 	                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++	02.17.09.02.08	 [0..1]  	 Text  	BD
 9.1.10  	 	                 Country  	 Country  	<Ctry>	+++++	02.17.09.02.09	 [0..1]  	 Code  	R
 9.1.11  	 	                 AddressLine  	 AddressLine  	<AdrLine>	+++++	02.17.09.02.10	 [0..7]  	 Text  	BD
 9.1.12  	 	             Identification  	 Identification  	<Id>	++++	02.17.09.03	 [0..1]  	 	C
 9.1.13  	 {Or  	                 OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	+++++	02.17.09.03.01	 [1..1]  	 	XOR
 9.1.14  	 	                     BICOrBEI  	 BICOrBEI  	<BICOrBEI>	++++++	02.17.09.03.01.01	 [0..1]  	 Identifier  	C
 9.1.15  	 	                     Other  	 Other  	<Othr>	++++++	02.17.09.03.01.02	 [0..n]  	 	C
 9.1.16  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.09.03.01.02.01	 [1..1]  	 Text  	R
 9.1.17  	 	                         SchemeName  	 SchemeName  	<SchmeNm>	+++++++	02.17.09.03.01.02.02	 [0..1]  	 	BD
 9.1.18  	 {{Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.09.03.01.02.02.01	 [1..1]  	 Code  	XOR
 9.1.19  	 Or}}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.09.03.01.02.02.02	 [1..1]  	 Text  	XOR
 9.1.20  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.09.03.01.02.03	 [0..1]  	 Text  	BD
 9.1.21  	 Or}  	                 PrivateIdentification  	 PrivateIdentification  	<PrvtId>	+++++	02.17.09.03.02	 [1..1]  	 	XOR
 9.1.22  	 	                     DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	++++++	02.17.09.03.02.01	 [0..1]  	 	BD
 9.1.23  	 	                         BirthDate  	 BirthDate  	<BirthDt>	+++++++	02.17.09.03.02.01.01	 [1..1]  	 DateTime  	R
 9.1.24  	 	                         ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	+++++++	02.17.09.03.02.01.02	 [0..1]  	 Text  	C
 9.1.25  	 	                         CityOfBirth  	 CityOfBirth  	<CityOfBirth>	+++++++	02.17.09.03.02.01.03	 [1..1]  	 Text  	R
 9.1.26  	 	                         CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	+++++++	02.17.09.03.02.01.04	 [1..1]  	 Code  	R
 9.1.27  	 	                     Other  	 Other  	<Othr>	++++++	02.17.09.03.02.02	 [0..n]  	 	BD
 9.1.28  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.09.03.02.02.01	 [1..1]  	 Text  	R
 9.1.29  	 	                         SchemeName  	 SchemeName  	<SchmeNm>	+++++++	02.17.09.03.02.02.02	 [0..1]  	 	BD
 9.1.30  	 {{Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.09.03.02.02.02.01	 [1..1]  	 Code  	XOR
 9.1.31  	 Or}}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.09.03.02.02.02.02	 [1..1]  	 Text  	XOR
 9.1.32  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.09.03.02.02.03	 [0..1]  	 Text  	BD
 9.1.33  	 	             CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	++++	02.17.09.04	 [0..1]  	 Code  	C
 9.1.34  	 	             ContactDetails  	 ContactDetails  	<CtctDtls>	++++	02.17.09.05	 [0..1]  	 	NU
 9.1.35  	 	                 NamePrefix  	 NamePrefix  	<NmPrfx>	+++++	02.17.09.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                 Name  	 Name  	<Nm>	+++++	02.17.09.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                 PhoneNumber  	 PhoneNumber  	<PhneNb>	+++++	02.17.09.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                 MobileNumber  	 MobileNumber  	<MobNb>	+++++	02.17.09.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                 FaxNumber  	 FaxNumber  	<FaxNb>	+++++	02.17.09.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                 EmailAddress  	 EmailAddress  	<EmailAdr>	+++++	02.17.09.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                 Other  	 Other  	<Othr>	+++++	02.17.09.05.07	 [0..1]  	 Text  	NU
 2.73  	 	         DebtorAccount  	 DebtorAccount  	<DbtrAcct>	+++	02.17.10	 [1..1]  	   	R
 1.1.0  	 	             Identification  	 Identification  	<Id>	++++	02.17.10.01	 [1..1]  	 	R
 1.1.1  	 {Or  	                 IBAN  	 IBAN  	<IBAN>	+++++	02.17.10.01.01	 [1..1]  	 Identifier  	XOR
 1.1.2  	 Or}  	                 Other  	 Other  	<Othr>	+++++	02.17.10.01.02	 [1..1]  	 	XOR
 1.1.3  	 	                     Identification  	 Identification  	<Id>	++++++	02.17.10.01.02.01	 [1..1]  	 Text  	R
 1.1.4  	 	                     SchemeName  	 SchemeName  	<SchmeNm>	++++++	02.17.10.01.02.02	 [0..1]  	 	BD
 1.1.5  	 {{Or  	                         Code  	 Code  	<Cd>	+++++++	02.17.10.01.02.02.01	 [1..1]  	 Code  	BD
 1.1.6  	 Or}}  	                         Proprietary  	 Proprietary  	<Prtry>	+++++++	02.17.10.01.02.02.02	 [1..1]  	 Text  	BD
 1.1.7  	 	                     Issuer  	 Issuer  	<Issr>	++++++	02.17.10.01.02.03	 [0..1]  	 Text  	BD
 1.1.8  	 	             Type  	 Type  	<Tp>	++++	02.17.10.02	 [0..1]  	 	C
 1.1.9  	 {Or  	                 Code  	 Code  	<Cd>	+++++	02.17.10.02.01	 [1..1]  	 Code  	XOR
 1.1.10  	 Or}  	                 Proprietary  	 Proprietary  	<Prtry>	+++++	02.17.10.02.02	 [1..1]  	 Text  	XOR
 1.1.11  	 	             Currency  	 Currency  	<Ccy>	++++	02.17.10.03	 [0..1]  	 Code  	R
 1.1.12  	 	             Name  	 Name  	<Nm>	++++	02.17.10.04	 [0..1]  	 Text  	BD
 2.74  	 	         UltimateDebtor  	 UltimateDebtor  	<UltmtDbtr>	+++	02.17.11	 [0..1]  	   	C
 9.1.0  	 	             Name  	 Name  	<Nm>	++++	02.17.11.01	 [0..1]  	 Text  	R
 9.1.1  	 	             PostalAddress  	 PostalAddress  	<PstlAdr>	++++	02.17.11.02	 [0..1]  	 	C
 9.1.2  	 	                 AddressType  	 AddressType  	<AdrTp>	+++++	02.17.11.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                 Department  	 Department  	<Dept>	+++++	02.17.11.02.02	 [0..1]  	 Text  	BD
 9.1.4  	 	                 SubDepartment  	 SubDepartment  	<SubDept>	+++++	02.17.11.02.03	 [0..1]  	 Text  	BD
 9.1.5  	 	                 StreetName  	 StreetName  	<StrtNm>	+++++	02.17.11.02.04	 [0..1]  	 Text  	BD
 9.1.6  	 	                 BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++	02.17.11.02.05	 [0..1]  	 Text  	BD
 9.1.7  	 	                 PostCode  	 PostCode  	<PstCd>	+++++	02.17.11.02.06	 [0..1]  	 Text  	BD
 9.1.8  	 	                 TownName  	 TownName  	<TwnNm>	+++++	02.17.11.02.07	 [0..1]  	 Text  	BD
 9.1.9  	 	                 CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++	02.17.11.02.08	 [0..1]  	 Text  	BD
 9.1.10  	 	                 Country  	 Country  	<Ctry>	+++++	02.17.11.02.09	 [0..1]  	 Code  	R
 9.1.11  	 	                 AddressLine  	 AddressLine  	<AdrLine>	+++++	02.17.11.02.10	 [0..7]  	 Text  	BD
 9.1.12  	 	             Identification  	 Identification  	<Id>	++++	02.17.11.03	 [0..1]  	 	C
 9.1.13  	 {Or  	                 OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	+++++	02.17.11.03.01	 [1..1]  	 	XOR
 9.1.14  	 	                     BICOrBEI  	 BICOrBEI  	<BICOrBEI>	++++++	02.17.11.03.01.01	 [0..1]  	 Identifier  	C
 9.1.15  	 	                     Other  	 Other  	<Othr>	++++++	02.17.11.03.01.02	 [0..n]  	 	C
 9.1.16  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.11.03.01.02.01	 [1..1]  	 Text  	R
 9.1.17  	 	                         SchemeName  	 SchemeName  	<SchmeNm>	+++++++	02.17.11.03.01.02.02	 [0..1]  	 	BD
 9.1.18  	 {{Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.11.03.01.02.02.01	 [1..1]  	 Code  	XOR
 9.1.19  	 Or}}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.11.03.01.02.02.02	 [1..1]  	 Text  	XOR
 9.1.20  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.11.03.01.02.03	 [0..1]  	 Text  	BD
 9.1.21  	 Or}  	                 PrivateIdentification  	 PrivateIdentification  	<PrvtId>	+++++	02.17.11.03.02	 [1..1]  	 	XOR
 9.1.22  	 	                     DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	++++++	02.17.11.03.02.01	 [0..1]  	 	BD
 9.1.23  	 	                         BirthDate  	 BirthDate  	<BirthDt>	+++++++	02.17.11.03.02.01.01	 [1..1]  	 DateTime  	C
 9.1.24  	 	                         ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	+++++++	02.17.11.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                         CityOfBirth  	 CityOfBirth  	<CityOfBirth>	+++++++	02.17.11.03.02.01.03	 [1..1]  	 Text  	R
 9.1.26  	 	                         CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	+++++++	02.17.11.03.02.01.04	 [1..1]  	 Code  	R
 9.1.27  	 	                     Other  	 Other  	<Othr>	++++++	02.17.11.03.02.02	 [0..n]  	 	BD
 9.1.28  	 	                         Identification  	 Identification  	<Id>	+++++++	02.17.11.03.02.02.01	 [1..1]  	 Text  	R
 9.1.29  	 	                         SchemeName  	 SchemeName  	<SchmeNm>	+++++++	02.17.11.03.02.02.02	 [0..1]  	 	BD
 9.1.30  	 {{Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.11.03.02.02.02.01	 [1..1]  	 Code  	XOR
 9.1.31  	 Or}}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.11.03.02.02.02.02	 [1..1]  	 Text  	XOR
 9.1.32  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.11.03.02.02.03	 [0..1]  	 Text  	BD
 9.1.33  	 	             CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	++++	02.17.11.04	 [0..1]  	 Code  	C
 9.1.34  	 	             ContactDetails  	 ContactDetails  	<CtctDtls>	++++	02.17.11.05	 [0..1]  	 	NU
 9.1.35  	 	                 NamePrefix  	 NamePrefix  	<NmPrfx>	+++++	02.17.11.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                 Name  	 Name  	<Nm>	+++++	02.17.11.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                 PhoneNumber  	 PhoneNumber  	<PhneNb>	+++++	02.17.11.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                 MobileNumber  	 MobileNumber  	<MobNb>	+++++	02.17.11.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                 FaxNumber  	 FaxNumber  	<FaxNb>	+++++	02.17.11.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                 EmailAddress  	 EmailAddress  	<EmailAdr>	+++++	02.17.11.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                 Other  	 Other  	<Othr>	+++++	02.17.11.05.07	 [0..1]  	 Text  	NU
 2.75  	 	         InstructionForCreditorAgent  	 InstructionForCreditorAgent  	<InstrForCdtrAgt>	+++	02.17.12	 [0..1]  	 Text  	C
 2.76  	 	         Purpose  	 Purpose  	<Purp>	+++	02.17.13	 [0..1]  	 	C
 2.77  	 {Or  	             Code  	 Code  	<Cd>	++++	02.17.13.01	 [1..1]  	 Code  	XOR
 2.78  	 Or}  	             Proprietary  	 Proprietary  	<Prtry>	++++	02.17.13.02	 [1..1]  	 Text  	XOR
 2.79  	 	         RegulatoryReporting  	 RegulatoryReporting  	<RgltryRptg>	+++	02.17.14	 [0..10]  	   	C
 11.1.0  		             DebitCreditReportingIndicator  	 DebitCreditReportingIndicator  	<DbtCdtRptgInd>	++++	02.17.14.01	 [0..1]  	 Code  	C
 11.1.1  		             Authority  	 Authority  	<Authrty>	++++	02.17.14.02	 [0..1]  	 	BD
 11.1.2  		                 Name  	 Name  	<Nm>	+++++	02.17.14.02.01	 [0..1]  	 Text  	BD
 11.1.3  		                 Country  	 Country  	<Ctry>	+++++	02.17.14.02.02	 [0..1]  	 Code  	BD
 11.1.4  		             Details  	 Details  	<Dtls>	++++	02.17.14.03	 [0..n]  	 	C
 11.1.5  		                 Type  	 Type  	<Tp>	+++++	02.17.14.03.01	 [0..1]  	 Text  	C
 11.1.6  		                 Date  	 Date  	<Dt>	+++++	02.17.14.03.02	 [0..1]  	 DateTime  	C
 11.1.7  		                 Country  	 Country  	<Ctry>	+++++	02.17.14.03.03	 [0..1]  	 Code  	C
 11.1.8  		                 Code  	 Code  	<Cd>	+++++	02.17.14.03.04	 [0..1]  	 Text  	C
 11.1.9  		                 Amount  	 Amount  	<Amt Ccy="AAA">	+++++	02.17.14.03.05	 [0..1]  	 Amount  	C
 11.1.10  		                 Information  	 Information  	<Inf>	+++++	02.17.14.03.06	 [0..n]  	 Text  	C
 2.80  	 	         Tax  	 Tax  	<Tax>	+++	02.17.15	 [0..1]  	   	C
 13.1.0  		             Creditor  	 Creditor  	<Cdtr>	++++	02.17.15.01	 [0..1]  	 	C
 13.1.1  		                 TaxIdentification  	 TaxIdentification  	<TaxId>	+++++	02.17.15.01.01	 [0..1]  	 Text  	C
 13.1.2  		                 RegistrationIdentification  	 RegistrationIdentification  	<RegnId>	+++++	02.17.15.01.02	 [0..1]  	 Text  	C
 13.1.3  		                 TaxType  	 TaxType  	<TaxTp>	+++++	02.17.15.01.03	 [0..1]  	 Text  	C
 13.1.4  		             Debtor  	 Debtor  	<Dbtr>	++++	02.17.15.02	 [0..1]  	 	C
 13.1.5  		                 TaxIdentification  	 TaxIdentification  	<TaxId>	+++++	02.17.15.02.01	 [0..1]  	 Text  	C
 13.1.6  		                 RegistrationIdentification  	 RegistrationIdentification  	<RegnId>	+++++	02.17.15.02.02	 [0..1]  	 Text  	C
 13.1.7  		                 TaxType  	 TaxType  	<TaxTp>	+++++	02.17.15.02.03	 [0..1]  	 Text  	C
 13.1.8  		                 Authorisation  	 Authorisation  	<Authstn>	+++++	02.17.15.02.04	 [0..1]  	 	C
 13.1.9  		                     Title  	 Title  	<Titl>	++++++	02.17.15.02.04.01	 [0..1]  	 Text  	C
 13.1.10  		                     Name  	 Name  	<Nm>	++++++	02.17.15.02.04.02	 [0..1]  	 Text  	C
 13.1.11  		             AdministrationZone  	 AdministrationZone  	<AdmstnZn>	++++	02.17.15.03	 [0..1]  	 Text  	C
 13.1.12  		             ReferenceNumber  	 ReferenceNumber  	<RefNb>	++++	02.17.15.04	 [0..1]  	 Text  	C
 13.1.13  		             Method  	 Method  	<Mtd>	++++	02.17.15.05	 [0..1]  	 Text  	C
 13.1.14  		             TotalTaxableBaseAmount  	 TotalTaxableBaseAmount  	<TtlTaxblBaseAmt Ccy="AAA">	++++	02.17.15.06	 [0..1]  	 Amount  	C
 13.1.15  		             TotalTaxAmount  	 TotalTaxAmount  	<TtlTaxAmt Ccy="AAA">	++++	02.17.15.07	 [0..1]  	 Amount  	C
 13.1.16  		             Date  	 Date  	<Dt>	++++	02.17.15.08	 [0..1]  	 DateTime  	C
 13.1.17  		             SequenceNumber  	 SequenceNumber  	<SeqNb>	++++	02.17.15.09	 [0..1]  	 Quantity  	C
 13.1.18  		             Record  	 Record  	<Rcrd>	++++	02.17.15.10	 [0..n]  	 	C
 13.1.19  		                 Type  	 Type  	<Tp>	+++++	02.17.15.10.01	 [0..1]  	 Text  	C
 13.1.20  		                 Category  	 Category  	<Ctgy>	+++++	02.17.15.10.02	 [0..1]  	 Text  	C
 13.1.21  		                 CategoryDetails  	 CategoryDetails  	<CtgyDtls>	+++++	02.17.15.10.03	 [0..1]  	 Text  	C
 13.1.22  		                 DebtorStatus  	 DebtorStatus  	<DbtrSts>	+++++	02.17.15.10.04	 [0..1]  	 Text  	C
 13.1.23  		                 CertificateIdentification  	 CertificateIdentification  	<CertId>	+++++	02.17.15.10.05	 [0..1]  	 Text  	C
 13.1.24  		                 FormsCode  	 FormsCode  	<FrmsCd>	+++++	02.17.15.10.06	 [0..1]  	 Text  	C
 13.1.25  		                 Period  	 Period  	<Prd>	+++++	02.17.15.10.07	 [0..1]  	 	C
 13.1.26  		                     Year  	 Year  	<Yr>	++++++	02.17.15.10.07.01	 [0..1]  	 DateTime  	C
 13.1.27  		                     Type  	 Type  	<Tp>	++++++	02.17.15.10.07.02	 [0..1]  	 Code  	C
 13.1.28  		                     FromToDate  	 FromToDate  	<FrToDt>	++++++	02.17.15.10.07.03	 [0..1]  	 	C
 13.1.29  		                         FromDate  	 FromDate  	<FrDt>	+++++++	02.17.15.10.07.03.01	 [1..1]  	 DateTime  	C
 13.1.30  		                         ToDate  	 ToDate  	<ToDt>	+++++++	02.17.15.10.07.03.02	 [1..1]  	 DateTime  	C
 13.1.31  		                 TaxAmount  	 TaxAmount  	<TaxAmt>	+++++	02.17.15.10.08	 [0..1]  	 	C
 13.1.32  		                     Rate  	 Rate  	<Rate>	++++++	02.17.15.10.08.01	 [0..1]  	 Rate  	C
 13.1.33  		                     TaxableBaseAmount  	 TaxableBaseAmount  	<TaxblBaseAmt Ccy="AAA">	++++++	02.17.15.10.08.02	 [0..1]  	 Amount  	C
 13.1.34  		                     TotalAmount  	 TotalAmount  	<TtlAmt Ccy="AAA">	++++++	02.17.15.10.08.03	 [0..1]  	 Amount  	C
 13.1.35  		                     Details  	 Details  	<Dtls>	++++++	02.17.15.10.08.04	 [0..n]  	 	C
 13.1.36  		                         Period  	 Period  	<Prd>	+++++++	02.17.15.10.08.04.01	 [0..1]  	 	C
 13.1.37  		                             Year  	 Year  	<Yr>	++++++++	02.17.15.10.08.04.01.01	 [0..1]  	 DateTime  	C
 13.1.38  		                             Type  	 Type  	<Tp>	++++++++	02.17.15.10.08.04.01.02	 [0..1]  	 Code  	C
 13.1.39  		                             FromToDate  	 FromToDate  	<FrToDt>	++++++++	02.17.15.10.08.04.01.03	 [0..1]  	 	C
 13.1.40  		                                 FromDate  	 FromDate  	<FrDt>	+++++++++	02.17.15.10.08.04.01.03.01	 [1..1]  	 DateTime  	C
 13.1.41  		                                 ToDate  	 ToDate  	<ToDt>	+++++++++	02.17.15.10.08.04.01.03.02	 [1..1]  	 DateTime  	C
 13.1.42  		                         Amount  	 Amount  	<Amt Ccy="AAA">	+++++++	02.17.15.10.08.04.02	 [1..1]  	 Amount  	C
 13.1.43  		                 AdditionalInformation  	 AdditionalInformation  	<AddtlInf>	+++++	02.17.15.10.09	 [0..1]  	 Text  	C
 2.81  	 	         RelatedRemittanceInformation  	 RelatedRemittanceInformation  	<RltdRmtInf>	+++	02.17.16	 [0..10]  	 	BD
 2.82  	 	             RemittanceIdentification  	 RemittanceIdentification  	<RmtId>	++++	02.17.16.01	 [0..1]  	 Text  	BD
 2.83  	 	             RemittanceLocationMethod  	 RemittanceLocationMethod  	<RmtLctnMtd>	++++	02.17.16.02	 [0..1]  	 Code  	BD
 2.84  	 	             RemittanceLocationElectronicAddress	 RemittanceLocationElectronicAddress	<RmtLctnElctrncAdr>	++++	02.17.16.03	 Text  		BD
 2.85  		             RemittanceLocationPostalAddress  	 RemittanceLocationPostalAddress  	<RmtLctnPstlAdr>	++++	02.17.16.04	 [0..1]  	 	BD
 2.86  		                 Name  	 Name  	<Nm>	+++++	02.17.16.04.01	 [1..1]  	 Text  	R
 2.87  		                 Address  	 Address  	<Adr>	+++++	02.17.16.04.02	 [1..1]  	   	R
 10.1.0  		                     AddressType  	 AddressType  	<AdrTp>	++++++	02.17.16.04.02.01	 [0..1]  	 Code  	NU
 10.1.1  		                     Department  	 Department  	<Dept>	++++++	02.17.16.04.02.02	 [0..1]  	 Text  	BD
 10.1.2  		                     SubDepartment  	 SubDepartment  	<SubDept>	++++++	02.17.16.04.02.03	 [0..1]  	 Text  	BD
 10.1.3  		                     StreetName  	 StreetName  	<StrtNm>	++++++	02.17.16.04.02.04	 [0..1]  	 Text  	BD
 10.1.4  		                     BuildingNumber  	 BuildingNumber  	<BldgNb>	++++++	02.17.16.04.02.05	 [0..1]  	 Text  	BD
 10.1.5  		                     PostCode  	 PostCode  	<PstCd>	++++++	02.17.16.04.02.06	 [0..1]  	 Text  	BD
 10.1.6  		                     TownName  	 TownName  	<TwnNm>	++++++	02.17.16.04.02.07	 [0..1]  	 Text  	BD
 10.1.7  		                     CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	++++++	02.17.16.04.02.08	 [0..1]  	 Text  	BD
 10.1.8  		                     Country  	 Country  	<Ctry>	++++++	02.17.16.04.02.09	 [0..1]  	 Code  	R
 10.1.9  		                     AddressLine  	 AddressLine  	<AdrLine>	++++++	02.17.16.04.02.10	 [0..7]  	 Text  	BD
 2.88  	 	         RemittanceInformation  	 RemittanceInformation  	<RmtInf>	+++	02.17.17	 [0..1]  	 	BD/C
 2.89  	 	             Unstructured  	 Unstructured  	<Ustrd>	++++	02.17.17.01	 [0..n]  	 Text  	BD/C
 2.90  	 	             Structured  	 Structured  	<Strd>	++++	02.17.17.02	 [0..n]  	 	BD/C
 2.91  	 	                 ReferredDocumentInformation  	 ReferredDocumentInformation  	<RfrdDocInf>	+++++	02.17.17.02.01	 [0..n]  	 	BD/C
 2.92  	 	                     Type  	 Type  	<Tp>	++++++	02.17.17.02.01.01	 [0..1]  	 	BD/C
 2.93  	 	                         CodeOrProprietary  	 CodeOrProprietary  	<CdOrPrtry>	+++++++	02.17.17.02.01.01.01	 [1..1]  	 	R
 2.94  	 {Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.17.02.01.01.01.01	 [1..1]  	 Code  	XOR
 2.95  	 Or}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.17.02.01.01.01.02	 [1..1]  	 Text  	XOR
 2.96  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.17.02.01.01.02	 [0..1]  	 Text  	BD
 2.97  	 	                     Number  	 Number  	<Nb>	++++++	02.17.17.02.01.02	 [0..1]  	 Text  	R
 2.98  	 	                     RelatedDate  	 RelatedDate  	<RltdDt>	++++++	02.17.17.02.01.03	 [0..1]  	 DateTime  	BD/C
 2.99  	 	                 ReferredDocumentAmount  	 ReferredDocumentAmount  	<RfrdDocAmt>	+++++	02.17.17.02.02	 [0..1]  	 	BD/C
 2.100  	 	                     DuePayableAmount  	 DuePayableAmount  	<DuePyblAmt Ccy="AAA">	++++++	02.17.17.02.02.01	 [0..1]  	 Amount  	BD/C
 2.101  	 	                     DiscountAppliedAmount  	 DiscountAppliedAmount  	<DscntApldAmt Ccy="AAA">	++++++	02.17.17.02.02.02	 [0..1]  	 Amount  	BD/C
 2.102  	 	                     CreditNoteAmount  	 CreditNoteAmount  	<CdtNoteAmt Ccy="AAA">	++++++	02.17.17.02.02.03	 [0..1]  	 Amount  	BD/C
 2.103  	 	                     TaxAmount  	 TaxAmount  	<TaxAmt Ccy="AAA">	++++++	02.17.17.02.02.04	 [0..1]  	 Amount  	BD/C
 2.104  	 	                     AdjustmentAmountAndReason	 AdjustmentAmountAndReason	<AdjstmntAmtAndRsn>	++++++	02.17.17.02.02.05	 [0..n]  	 	BD/C
 2.105  	 	                         Amount  	 Amount  	<Amt Ccy="AAA">	+++++++	02.17.17.02.02.05.01	 [1..1]  	 Amount  	R
 2.106  	 	                         CreditDebitIndicator  	 CreditDebitIndicator  	<CdtDbtInd>	+++++++	02.17.17.02.02.05.02	 [0..1]  	 Code  	BD/C
 2.107  	 	                         Reason  	 Reason  	<Rsn>	+++++++	02.17.17.02.02.05.03	 [0..1]  	 Text  	BD/C
 2.108  	 	                         AdditionalInformation  	 AdditionalInformation  	<AddtlInf>	+++++++	02.17.17.02.02.05.04	 [0..1]  	 Text  	BD/C
 2.109  	 	                     RemittedAmount  	 RemittedAmount  	<RmtdAmt Ccy="AAA">	++++++	02.17.17.02.02.06	 [0..1]  	 Amount  	BD/C
 2.110  	 	                 CreditorReferenceInformation  	 CreditorReferenceInformation  	<CdtrRefInf>	+++++	02.17.17.02.03	 [0..1]  	 	BD
 2.111  	 	                     Type  	 Type  	<Tp>	++++++	02.17.17.02.03.01	 [0..1]  	 	BD
 2.112  	 	                         CodeOrProprietary  	 CodeOrProprietary  	<CdOrPrtry>	+++++++	02.17.17.02.03.01.01	 [1..1]  	 	R
 2.113  	 {Or  	                             Code  	 Code  	<Cd>	++++++++	02.17.17.02.03.01.01.01	 [1..1]  	 Code  	XOR
 2.114  	 Or}  	                             Proprietary  	 Proprietary  	<Prtry>	++++++++	02.17.17.02.03.01.01.02	 [1..1]  	 Text  	XOR
 2.115  	 	                         Issuer  	 Issuer  	<Issr>	+++++++	02.17.17.02.03.01.02	 [0..1]  	 Text  	BD
 2.116  	 	                     Reference  	 Reference  	<Ref>	++++++	02.17.17.02.03.02	 [0..1]  	 Text  	R
 2.117  	 	                 Invoicer  	 Invoicer  	<Invcr>	+++++	02.17.17.02.04	 [0..1]  	   	BD
 9.1.0  	 	                     Name  	 Name  	<Nm>	++++++	02.17.17.02.04.01	 [0..1]  	 Text  	R
 9.1.1  	 	                     PostalAddress  	 PostalAddress  	<PstlAdr>	++++++	02.17.17.02.04.02	 [0..1]  	 	NU
 9.1.2  	 	                         AddressType  	 AddressType  	<AdrTp>	+++++++	02.17.17.02.04.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                         Department  	 Department  	<Dept>	+++++++	02.17.17.02.04.02.02	 [0..1]  	 Text  	NU
 9.1.4  	 	                         SubDepartment  	 SubDepartment  	<SubDept>	+++++++	02.17.17.02.04.02.03	 [0..1]  	 Text  	NU
 9.1.5  	 	                         StreetName  	 StreetName  	<StrtNm>	+++++++	02.17.17.02.04.02.04	 [0..1]  	 Text  	NU
 9.1.6  	 	                         BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++++	02.17.17.02.04.02.05	 [0..1]  	 Text  	NU
 9.1.7  	 	                         PostCode  	 PostCode  	<PstCd>	+++++++	02.17.17.02.04.02.06	 [0..1]  	 Text  	NU
 9.1.8  	 	                         TownName  	 TownName  	<TwnNm>	+++++++	02.17.17.02.04.02.07	 [0..1]  	 Text  	NU
 9.1.9  	 	                         CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++++	02.17.17.02.04.02.08	 [0..1]  	 Text  	NU
 9.1.10  	 	                         Country  	 Country  	<Ctry>	+++++++	02.17.17.02.04.02.09	 [0..1]  	 Code  	NU
 9.1.11  	 	                         AddressLine  	 AddressLine  	<AdrLine>	+++++++	02.17.17.02.04.02.10	 [0..7]  	 Text  	NU
 9.1.12  	 	                     Identification  	 Identification  	<Id>	++++++	02.17.17.02.04.03	 [0..1]  	 	NU
 9.1.13  	 {Or  	                         OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	+++++++	02.17.17.02.04.03.01	 [1..1]  	 	NU
 9.1.14  	 	                             BICOrBEI  	 BICOrBEI  	<BICOrBEI>	++++++++	02.17.17.02.04.03.01.01	 [0..1]  	 Identifier  	NU
 9.1.15  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.17.02.04.03.01.02	 [0..n]  	 	NU
 9.1.16  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.17.02.04.03.01.02.01	 [1..1]  	 Text  	NU
 9.1.17  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.17.02.04.03.01.02.02	 [0..1]  	 	NU
 9.1.18  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.17.02.04.03.01.02.02.01	 [1..1]  	 Code  	NU
 9.1.19  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.17.02.04.03.01.02.02.02	 [1..1]  	 Text  	NU
 9.1.20  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.17.02.04.03.01.02.03	 [0..1]  	 Text  	NU
 9.1.21  	 Or}  	                         PrivateIdentification  	 PrivateIdentification  	<PrvtId>	+++++++	02.17.17.02.04.03.02	 [1..1]  	 	NU
 9.1.22  	 	                             DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	++++++++	02.17.17.02.04.03.02.01	 [0..1]  	 	NU
 9.1.23  	 	                                 BirthDate  	 BirthDate  	<BirthDt>	+++++++++	02.17.17.02.04.03.02.01.01	 [1..1]  	 DateTime  	NU
 9.1.24  	 	                                 ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	+++++++++	02.17.17.02.04.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                                 CityOfBirth  	 CityOfBirth  	<CityOfBirth>	+++++++++	02.17.17.02.04.03.02.01.03	 [1..1]  	 Text  	NU
 9.1.26  	 	                                 CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	+++++++++	02.17.17.02.04.03.02.01.04	 [1..1]  	 Code  	NU
 9.1.27  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.17.02.04.03.02.02	 [0..n]  	 	NU
 9.1.28  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.17.02.04.03.02.02.01	 [1..1]  	 Text  	NU
 9.1.29  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.17.02.04.03.02.02.02	 [0..1]  	 	NU
 9.1.30  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.17.02.04.03.02.02.02.01	 [1..1]  	 Code  	NU
 9.1.31  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.17.02.04.03.02.02.02.02	 [1..1]  	 Text  	NU
 9.1.32  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.17.02.04.03.02.02.03	 [0..1]  	 Text  	NU
 9.1.33  	 	                     CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	++++++	02.17.17.02.04.04	 [0..1]  	 Code  	NU
 9.1.34  	 	                     ContactDetails  	 ContactDetails  	<CtctDtls>	++++++	02.17.17.02.04.05	 [0..1]  	 	NU
 9.1.35  	 	                         NamePrefix  	 NamePrefix  	<NmPrfx>	+++++++	02.17.17.02.04.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.17.02.04.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                         PhoneNumber  	 PhoneNumber  	<PhneNb>	+++++++	02.17.17.02.04.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                         MobileNumber  	 MobileNumber  	<MobNb>	+++++++	02.17.17.02.04.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                         FaxNumber  	 FaxNumber  	<FaxNb>	+++++++	02.17.17.02.04.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                         EmailAddress  	 EmailAddress  	<EmailAdr>	+++++++	02.17.17.02.04.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                         Other  	 Other  	<Othr>	+++++++	02.17.17.02.04.05.07	 [0..1]  	 Text  	NU
 2.118  	 	                 Invoicee  	 Invoicee  	<Invcee>	+++++	02.17.17.02.05			BD
 9.1.0  	 	                     Name  	 Name  	<Nm>	++++++	02.17.17.02.05.01	 [0..1]  	 Text  	R
 9.1.1  	 	                     PostalAddress  	 PostalAddress  	<PstlAdr>	++++++	02.17.17.02.05.02	 [0..1]  	 	NU
 9.1.2  	 	                         AddressType  	 AddressType  	<AdrTp>	+++++++	02.17.17.02.05.02.01	 [0..1]  	 Code  	NU
 9.1.3  	 	                         Department  	 Department  	<Dept>	+++++++	02.17.17.02.05.02.02	 [0..1]  	 Text  	NU
 9.1.4  	 	                         SubDepartment  	 SubDepartment  	<SubDept>	+++++++	02.17.17.02.05.02.03	 [0..1]  	 Text  	NU
 9.1.5  	 	                         StreetName  	 StreetName  	<StrtNm>	+++++++	02.17.17.02.05.02.04	 [0..1]  	 Text  	NU
 9.1.6  	 	                         BuildingNumber  	 BuildingNumber  	<BldgNb>	+++++++	02.17.17.02.05.02.05	 [0..1]  	 Text  	NU
 9.1.7  	 	                         PostCode  	 PostCode  	<PstCd>	+++++++	02.17.17.02.05.02.06	 [0..1]  	 Text  	NU
 9.1.8  	 	                         TownName  	 TownName  	<TwnNm>	+++++++	02.17.17.02.05.02.07	 [0..1]  	 Text  	NU
 9.1.9  	 	                         CountrySubDivision  	 CountrySubDivision  	<CtrySubDvsn>	+++++++	02.17.17.02.05.02.08	 [0..1]  	 Text  	NU
 9.1.10  	 	                         Country  	 Country  	<Ctry>	+++++++	02.17.17.02.05.02.09	 [0..1]  	 Code  	NU
 9.1.11  	 	                         AddressLine  	 AddressLine  	<AdrLine>	+++++++	02.17.17.02.05.02.10	 [0..7]  	 Text  	NU
 9.1.12  	 	                     Identification  	 Identification  	<Id>	++++++	02.17.17.02.05.03	 [0..1]  	 	NU
 9.1.13  	 {Or  	                         OrganisationIdentification  	 OrganisationIdentification  	<OrgId>	+++++++	02.17.17.02.05.03.01	 [1..1]  	 	NU
 9.1.14  	 	                             BICOrBEI  	 BICOrBEI  	<BICOrBEI>	++++++++	02.17.17.02.05.03.01.01	 [0..1]  	 Identifier  	NU
 9.1.15  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.17.02.05.03.01.02	 [0..n]  	 	NU
 9.1.16  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.17.02.05.03.01.02.01	 [1..1]  	 Text  	NU
 9.1.17  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.17.02.05.03.01.02.02	 [0..1]  	 	NU
 9.1.18  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.17.02.05.03.01.02.02.01	 [1..1]  	 Code  	NU
 9.1.19  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.17.02.05.03.01.02.02.02	 [1..1]  	 Text  	NU
 9.1.20  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.17.02.05.03.01.02.03	 [0..1]  	 Text  	NU
 9.1.21  	 Or}  	                         PrivateIdentification  	 PrivateIdentification  	<PrvtId>	+++++++	02.17.17.02.05.03.02	 [1..1]  	 	NU
 9.1.22  	 	                             DateAndPlaceOfBirth  	 DateAndPlaceOfBirth  	<DtAndPlcOfBirth>	++++++++	02.17.17.02.05.03.02.01	 [0..1]  	 	NU
 9.1.23  	 	                                 BirthDate  	 BirthDate  	<BirthDt>	+++++++++	02.17.17.02.05.03.02.01.01	 [1..1]  	 DateTime  	NU
 9.1.24  	 	                                 ProvinceOfBirth  	 ProvinceOfBirth  	<PrvcOfBirth>	+++++++++	02.17.17.02.05.03.02.01.02	 [0..1]  	 Text  	NU
 9.1.25  	 	                                 CityOfBirth  	 CityOfBirth  	<CityOfBirth>	+++++++++	02.17.17.02.05.03.02.01.03	 [1..1]  	 Text  	NU
 9.1.26  	 	                                 CountryOfBirth  	 CountryOfBirth  	<CtryOfBirth>	+++++++++	02.17.17.02.05.03.02.01.04	 [1..1]  	 Code  	NU
 9.1.27  	 	                             Other  	 Other  	<Othr>	++++++++	02.17.17.02.05.03.02.02	 [0..n]  	 	NU
 9.1.28  	 	                                 Identification  	 Identification  	<Id>	+++++++++	02.17.17.02.05.03.02.02.01	 [1..1]  	 Text  	NU
 9.1.29  	 	                                 SchemeName  	 SchemeName  	<SchmeNm>	+++++++++	02.17.17.02.05.03.02.02.02	 [0..1]  	 	NU
 9.1.30  	 {{Or  	                                     Code  	 Code  	<Cd>	++++++++++	02.17.17.02.05.03.02.02.02.01	 [1..1]  	 Code  	NU
 9.1.31  	 Or}}  	                                     Proprietary  	 Proprietary  	<Prtry>	++++++++++	02.17.17.02.05.03.02.02.02.02	 [1..1]  	 Text  	NU
 9.1.32  	 	                                 Issuer  	 Issuer  	<Issr>	+++++++++	02.17.17.02.05.03.02.02.03	 [0..1]  	 Text  	NU
 9.1.33  	 	                     CountryOfResidence  	 CountryOfResidence  	<CtryOfRes>	++++++	02.17.17.02.05.04	 [0..1]  	 Code  	NU
 9.1.34  	 	                     ContactDetails  	 ContactDetails  	<CtctDtls>	++++++	02.17.17.02.05.05	 [0..1]  	 	NU
 9.1.35  	 	                         NamePrefix  	 NamePrefix  	<NmPrfx>	+++++++	02.17.17.02.05.05.01	 [0..1]  	 Code  	NU
 9.1.36  	 	                         Name  	 Name  	<Nm>	+++++++	02.17.17.02.05.05.02	 [0..1]  	 Text  	NU
 9.1.37  	 	                         PhoneNumber  	 PhoneNumber  	<PhneNb>	+++++++	02.17.17.02.05.05.03	 [0..1]  	 Text  	NU
 9.1.38  	 	                         MobileNumber  	 MobileNumber  	<MobNb>	+++++++	02.17.17.02.05.05.04	 [0..1]  	 Text  	NU
 9.1.39  	 	                         FaxNumber  	 FaxNumber  	<FaxNb>	+++++++	02.17.17.02.05.05.05	 [0..1]  	 Text  	NU
 9.1.40  	 	                         EmailAddress  	 EmailAddress  	<EmailAdr>	+++++++	02.17.17.02.05.05.06	 [0..1]  	 Text  	NU
 9.1.41  	 	                         Other  	 Other  	<Othr>	+++++++	02.17.17.02.05.05.07	 [0..1]  	 Text  	NU
 2.119  	 	                 AdditionalRemittanceInformation  	 AdditionalRemittanceInformation  	<AddtlRmtInf>	+++++	02.17.17.02.06	[0..3]	Text	BD

	
	*/
	private String InstrId;
	private String EndToEndId;
	private String Cd_SvcLvl;
	private double InstdAmt;
	private String Ctry_PstlAdr_CdtrAgt;
	private String Nm_Cdtr;
	private String Ctry_PstlAdr_Cdtr;
	private String AdrLine_PstlAdr;
	private String AdrLine2_PstlAdr;
	private String IBAN;
	private String Cd_Purp;
	private String Ustrd;
	
	
	public String getInstrId() {
		return InstrId;
	}
	public void setInstrId(String instrId) {
		InstrId = instrId;
	}
	public String getEndToEndId() {
		return EndToEndId;
	}
	public void setEndToEndId(String endToEndId) {
		EndToEndId = endToEndId;
	}
	public String getCd_SvcLvl() {
		return Cd_SvcLvl;
	}
	public void setCd_SvcLvl(String cd_SvcLvl) {
		Cd_SvcLvl = cd_SvcLvl;
	}
	public double getInstdAmt() {
		return InstdAmt;
	}
	public String getInstdAmt2String() {
		
		DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
		DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
		// String InstdAmtStr = df.format(this.InstdAmt);
		return formateador.format(this.InstdAmt);
	}
	public void setInstdAmt(double instdAmt) {
		InstdAmt = instdAmt;
	}
	public String getCtry_PstlAdr_CdtrAgt() {
		return Ctry_PstlAdr_CdtrAgt;
	}
	public void setCtry_PstlAdr_CdtrAgt(String ctry_PstlAdr_CdtrAgt) {
		Ctry_PstlAdr_CdtrAgt = ctry_PstlAdr_CdtrAgt;
	}
	public String getNm_Cdtr() {
		return Nm_Cdtr;
	}
	public void setNm_Cdtr(String nm_Cdtr) {
		Nm_Cdtr = nm_Cdtr;
	}
	public String getCtry_PstlAdr_Cdtr() {
		return Ctry_PstlAdr_Cdtr;
	}
	public void setCtry_PstlAdr_Cdtr(String ctry_PstlAdr_Cdtr) {
		Ctry_PstlAdr_Cdtr = ctry_PstlAdr_Cdtr;
	}
	public String getAdrLine_PstlAdr() {
		return AdrLine_PstlAdr;
	}
	public void setAdrLine_PstlAdr(String adrLine_PstlAdr) {
		AdrLine_PstlAdr = adrLine_PstlAdr;
	}
	public String getAdrLine2_PstlAdr() {
		return AdrLine2_PstlAdr;
	}
	public void setAdrLine2_PstlAdr(String adrLine2_PstlAdr) {
		AdrLine2_PstlAdr = adrLine2_PstlAdr;
	}
	
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getCd_Purp() {
		return Cd_Purp;
	}
	public void setCd_Purp(String cd_Purp) {
		Cd_Purp = cd_Purp;
	}
	public String getUstrd() {
		return Ustrd;
	}
	public void setUstrd(String ustrd) {
		Ustrd = ustrd;
	}

	
	
}

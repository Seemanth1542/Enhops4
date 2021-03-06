package KvbTestCases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.Screenshot;
import Common.TestDataProvider;
import KvbPages.Kvb_MSME_Loan;
import TestBase.TestBase;

public class TC002_kvb_MSME_Loan extends TestBase {

	
	Kvb_MSME_Loan kvb_MSME_Loan;
	
	@DataProvider
	public Object[][] testData() throws Exception {
		Object data[][] = TestDataProvider.excelReader(Repository.getProperty("KvbTestDataFilePath"),Repository.getProperty("kvb_MSME_Loan_sheetname"));
		return data;
	}
	
	@BeforeClass
	public void TestEngine() {
		try {
			kvb_MSME_Loan=new Kvb_MSME_Loan(driver);
			init();
			log.info(getClass().getName() + "Test is started");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider="testData")
	public void kvb_MSME_Loan(String namee,String mobileNumm,String constitutionn,String lineofActivitypresent,String lineofActivityProposed,
			String dateOfIncorporationn,String industryTypee,String VAT_TIN_Numberr,String PAN_Numberr,String emailIdd,
			String statee,String districtt,String branchh,String purposeOfLoann,String termLoann,String workingCapitall,String otherss,
			String factoryAddresss,String factoryCityy,String factoryPhNumm,
			String factoryPincodee,String factoryCountryy,String communicationAddresss,String communicationCityy,String communicationPhNumm,
			String communicationPincodee,String communicationCountryy,String runmode) {
		
		try {
			test.assignCategory("RegressionTest");
			if (runmode.equalsIgnoreCase("N")) {
				throw new SkipException("Runmode flag set as No");
			}
			Screenshot.infoScreenshot(driver, "KVB Bank MSME Loan process");
			Kvb_MSME_Loan.MSME_loan();
			Kvb_MSME_Loan.borrowers_Profile(namee, mobileNumm, constitutionn, lineofActivitypresent, lineofActivityProposed, dateOfIncorporationn, industryTypee, 
					VAT_TIN_Numberr, PAN_Numberr, emailIdd, statee, districtt, branchh);
			Kvb_MSME_Loan.loan_applied_for(purposeOfLoann, termLoann, workingCapitall, otherss);
			Kvb_MSME_Loan.factory_Unit_Address(factoryAddresss, factoryCityy, factoryPhNumm, factoryPincodee, factoryCountryy);
			Kvb_MSME_Loan.address_forCommunication(communicationAddresss, communicationCityy, communicationPhNumm, communicationPincodee, communicationCountryy);
			Screenshot.infoScreenshot(driver, "KVB Bank MSME Loan process");
	
		} catch (Exception e) {
			e.getMessage();
		}
	}
	@AfterClass(alwaysRun = true)
	public void endreport() {
		closeBrowser();
	}



}

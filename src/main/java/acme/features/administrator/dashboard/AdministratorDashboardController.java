
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.features.authenticated.companyRecord.AuthenticatedCompanyRecordListService;
import acme.features.authenticated.investorRecord.AuthenticatedInvestorRecordListService;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/dashboard/")
public class AdministratorDashboardController<Dashboard> extends AbstractController<Administrator, Dashboard> {

	@Autowired
	private AuthenticatedCompanyRecordListService	listServiceCompany;
	@Autowired
	private AuthenticatedInvestorRecordListService	listServiceInvestor;


	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		result = new ModelAndView();
		Object[] totalCompanies = this.listServiceCompany.getCompaniesBySector();
		Collection<Long> totalInvestors = this.listServiceInvestor.getInvestorsBySector();
		result.addObject("totalCompanies", totalCompanies);
		result.addObject("totalInvestors", totalInvestors);

		return result;

	}
}

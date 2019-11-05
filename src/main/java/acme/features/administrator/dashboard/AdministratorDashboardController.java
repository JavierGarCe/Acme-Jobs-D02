
package acme.features.administrator.dashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.forms.dashboards.Dashboard;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/dashboard/")
public class AdministratorDashboardController extends AbstractController<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardShowService showService;


	@PostConstruct
	private void initialize() {
		super.addCustomCommand(CustomCommand.LISTING, BasicCommand.SHOW, this.showService);
	}
}


package acme.features.authenticated.investorRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecord.InvestorRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedInvestorRecordListService implements AbstractListService<Authenticated, InvestorRecord> {
	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedInvestorRecordRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector");

	}

	@Override
	public Collection<InvestorRecord> findMany(final Request<InvestorRecord> request) {
		assert request != null;
		Collection<InvestorRecord> result;
		result = this.repository.findMany();
		return result;
	}

	public Collection<Long> getInvestorsBySector() {

		return this.convierteACollection(this.repository.investorsBySector());
	}
	public Collection<Long> convierteACollection(final Object[] objetos) {
		List<Long> res = new ArrayList<>();
		for (Object i : objetos) {
			res.add((Long) i);
		}

		return res;

	}

}

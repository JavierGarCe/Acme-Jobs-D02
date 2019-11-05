
package acme.form.dashboards;

import java.io.Serializable;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Collection<Long>			totalInvestors;
	Collection<Long>			totalCompanies;
}

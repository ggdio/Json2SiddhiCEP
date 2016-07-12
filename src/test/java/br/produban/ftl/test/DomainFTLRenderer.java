package br.produban.ftl.test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URISyntaxException;

import br.produban.domain.query.Condition;
import br.produban.domain.query.Conditional;
import br.produban.domain.query.Criteria;
import br.produban.domain.query.Operator;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class DomainFTLRenderer {
	
	private static Configuration cfg;
	
	public DomainFTLRenderer() {
		// TODO Auto-generated constructor stub
	}

	private String render(Criteria criteria) {
		try(Writer out = new StringWriter();) {
			if(cfg == null) cfg = loadFTLConfig();
			
			Template template = cfg.getTemplate("filter.ftl");
//			template.process(new HashMap<String, Object>(){{put("criteria", criteria);}}, out);
			template.process(criteria, out);
			
			return out.toString();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
			
		} finally {
			
		}
	}
	
	private static Configuration loadFTLConfig() throws IOException, URISyntaxException {
		Configuration cfg = new Configuration(Configuration.getVersion());
		cfg.setDirectoryForTemplateLoading(new File(DomainFTLRenderer.class.getResource("/templates/ftl").toURI()));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		return cfg;
	}
	
	public static void main(String[] args) {
		Criteria criteria = new Criteria()
			.addCriteria(new Condition("xpto", Conditional.EQUAL, "X"), new Condition(Operator.OR, "xpto", Conditional.EQUAL, "Y"))
			.addCondition("name", Conditional.EQUAL, "Dio")
			.addCondition(Operator.AND ,"age", Conditional.GRATER_OR_EQUAL, 25)
			.addCondition(Operator.AND ,"age", Conditional.LOWER_OR_EQUAL, 30);
		
		DomainFTLRenderer renderer = new DomainFTLRenderer();
		
		System.out.println(renderer.render(criteria));
	}
	
}
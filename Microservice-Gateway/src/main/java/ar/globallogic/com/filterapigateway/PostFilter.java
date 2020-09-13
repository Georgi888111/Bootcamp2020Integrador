package ar.globallogic.com.filterapigateway;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = ctx.getResponse();
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

		log.info("token: " + response.getHeader("x-application-context") + " | "
				+ ctx.getResponse().getHeader("cache-control"));
		log.info("to: " + servletResponse.getHeader("authorization"));
		log.info(ctx.getResponse().containsHeader("authorization") + "");
		log.info("PostFilter: " + String.format("response's content type is %s", response.getStatus()));

		return null;
	}

}

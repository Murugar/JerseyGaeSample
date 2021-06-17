package com.iqmsoft.api;

import com.iqmsoft.engine.MyImpl;
import com.iqmsoft.engine.MyIntf;
import com.iqmsoft.gae.GuiceRestListener;

public class RestConfig extends GuiceRestListener
{
	private static final String URL_PATTERN = "/v1/*";
	private static final String JERSEY_ROOT_PACKAGE = RestConfig.class.getPackage().getName();

	public RestConfig()
	{
		super(new GuiceRestModule()
		{
			@Override
			protected String getServingUrl()
			{
				return URL_PATTERN;
			}

			@Override
			protected String getRootPackage()
			{
				return JERSEY_ROOT_PACKAGE;
			}

			@Override
			protected void doCustomBinds()
			{
				bind(MyIntf.class).to(MyImpl.class);
			}
		});
	}
}

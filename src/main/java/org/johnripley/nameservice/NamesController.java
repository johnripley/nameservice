package org.johnripley.nameservice;

import org.johnripley.nameinfo.BaseNameInfo;
import org.johnripley.nameinfo.GenderInfo;
import org.johnripley.nameinfo.NameLookup;
import org.johnripley.nameinfo.NameLookupInfo;
import org.johnripley.nameinfo.NameStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NamesController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "nameservice/stats", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public NameStats name(@RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "year", defaultValue = "0") int year) {
    	return context.getBean(NameLookup.class).getStatistic(new BaseNameInfo(name,year));
    }

    @RequestMapping(value = "nameservice/gender", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public GenderInfo gender(@RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "year", defaultValue = "0") int year) {
	return context.getBean(NameLookup.class).getGender(new BaseNameInfo(name,year));
    }

    @RequestMapping(value = "nameservice/info", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public NameLookupInfo info() {
	return context.getBean(NameLookup.class).getInfo();
    }

}

/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.june.shop.site.web;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.june.shop.site.model.Owner;
import com.june.shop.site.service.SampleService;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
@SessionAttributes(types = Owner.class)
public class SampleController {
	protected static final Logger logger = LoggerFactory
			.getLogger(SampleController.class);
	@Autowired
    private SampleService sampleService;
	

    /**
     * Custom handler for displaying an owner.
     *
     * @param ownerId the ID of the owner to display
     * @return a ModelMap with the model attributes for the view
     */
    @RequestMapping("/sample/list")
    public ModelAndView sampleList() {
        ModelAndView mav = new ModelAndView("site/sample/sampleList");
        Collection<Owner> list = sampleService.sampleList();
        mav.addObject("list", list);
        return mav;
    }
    
    @RequestMapping("/sample/device")
    public ModelAndView home(Device device) {
        if (device.isMobile()) {
            logger.info("Hello mobile user!");
        } else if (device.isTablet()) {
            logger.info("Hello tablet user!");
        } else {
            logger.info("Hello desktop user!");         
        }
        
        
        ModelAndView mav = new ModelAndView("site/sample/sampleList");
        
        mav.addObject("device", device);
        return mav;
    }


}

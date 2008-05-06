/*
 * Copyright (C) 2005-2007 Alfresco Software Limited.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

 * As a special exception to the terms and conditions of version 2.0 of 
 * the GPL, you may redistribute this Program in connection with Free/Libre 
 * and Open Source Software ("FLOSS") applications as described in Alfresco's 
 * FLOSS exception.  You should have recieved a copy of the text describing 
 * the FLOSS exception, and it is also available here: 
 * http://www.alfresco.com/legal/licensing"
 */
package org.alfresco.repo.web.scripts.site;

import java.util.ArrayList;
import java.util.List;

import org.alfresco.repo.web.scripts.BaseWebScriptTest;
import org.alfresco.util.GUID;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Unit test to test site Web Script API
 * 
 * @author Roy Wetherall
 */
public class SiteServiceTest extends BaseWebScriptTest
{    
    private static final String URL_SITES = "/api/sites";
    private static final String URL_SITE = "/api/site/";
    
    private List<String> createdSites = new ArrayList<String>(5);
    
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
        
        // Tidy-up any site's create during the execution of the test
        for (String shortName : this.createdSites)
        {
            deleteRequest(URL_SITE + shortName, 0);
        }
        
        // Clear the list
        this.createdSites.clear();
    }
    
    public void testCreateSite() throws Exception
    {
        String shortName  = GUID.generate();
        
        // Create a new site
        JSONObject result = createSite("myPreset", shortName, "myTitle", "myDescription", true, 200);        
        assertEquals("myPreset", result.get("sitePreset"));
        assertEquals(shortName, result.get("shortName"));
        assertEquals("myTitle", result.get("title"));
        assertEquals("myDescription", result.get("description"));
        assertTrue(result.getBoolean("isPublic"));
        
        // Check for duplicate names
        createSite("myPreset", shortName, "myTitle", "myDescription", true, 500); 
    }
    
    private JSONObject createSite(String sitePreset, String shortName, String title, String description, boolean isPublic, int expectedStatus)
        throws Exception
    {
        JSONObject site = new JSONObject();
        site.put("sitePreset", sitePreset);
        site.put("shortName", shortName);
        site.put("title", title);
        site.put("description", description);
        site.put("isPublic", isPublic);                
        MockHttpServletResponse response = postRequest(URL_SITES, expectedStatus, site.toString(), "application/json"); 
        this.createdSites.add(shortName);
        return new JSONObject(response.getContentAsString());
    }
    
    public void testGetSites() throws Exception
    {
        // == Test basic GET with no filters ==
        
        MockHttpServletResponse response = getRequest(URL_SITES, 200);        
        JSONArray result = new JSONArray(response.getContentAsString());
        
        // TODO formalise this test once i can be sure that i know what's already in the site store 
        //      ie: .. i need to clean up after myself in this test 
        
        System.out.println(response.getContentAsString());
    }
    
    public void testGetSite() throws Exception
    {
        // Get a site that doesn't exist
        MockHttpServletResponse response = getRequest(URL_SITE + "somerandomshortname", 404);
        
        // Create a site and get it
        String shortName  = GUID.generate();
        JSONObject result = createSite("myPreset", shortName, "myTitle", "myDescription", true, 200);
        response = getRequest(URL_SITE + shortName, 200);
       
    }
    
    public void testUpdateSite() throws Exception
    {
        // Create a site
        String shortName  = GUID.generate();
        JSONObject result = createSite("myPreset", shortName, "myTitle", "myDescription", true, 200);
        
        // Update the site
        result.put("title", "abs123abc");
        result.put("description", "123abc123");
        result.put("isPublic", false);
        MockHttpServletResponse response = putRequest(URL_SITE + shortName, 200, result.toString(), "application/json");
        result = new JSONObject(response.getContentAsString());
        assertEquals("abs123abc", result.get("title"));
        assertEquals("123abc123", result.get("description"));
        assertFalse(result.getBoolean("isPublic"));
        
        // Try and get the site and double check it's changed
        response = getRequest(URL_SITE + shortName, 200);
        result = new JSONObject(response.getContentAsString());
        assertEquals("abs123abc", result.get("title"));
        assertEquals("123abc123", result.get("description"));
        assertFalse(result.getBoolean("isPublic"));
    }
    
    public void testDeleteSite() throws Exception
    {
        // Delete non-existant site
        MockHttpServletResponse response = deleteRequest(URL_SITE + "somerandomshortname", 404);
        
        // Create a site
        String shortName  = GUID.generate();
        JSONObject result = createSite("myPreset", shortName, "myTitle", "myDescription", true, 200);
        
        // Get the site
        response = getRequest(URL_SITE + shortName, 200);
        
        // Delete the site
        response = deleteRequest(URL_SITE + shortName, 200);
        
        // Get the site
        response = getRequest(URL_SITE + shortName, 404);
    }

}

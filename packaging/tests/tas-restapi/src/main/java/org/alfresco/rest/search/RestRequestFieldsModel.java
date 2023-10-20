/*-
 * #%L
 * alfresco-tas-restapi
 * %%
 * Copyright (C) 2005 - 2023 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.rest.search;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.alfresco.rest.core.IRestModel;
import org.alfresco.utility.model.TestModel;

/**
 * Generated by 'msuzuki' on '2017-02-24 09:26' from 'Alfresco Content Services REST API' swagger file 
 * Generated from 'Alfresco Content Services REST API' swagger file
 * Base Path {@linkplain /alfresco/api/-default-/public/search/versions/1}
 */
public class RestRequestFieldsModel extends TestModel implements IRestModel<RestRequestFieldsModel>
{
    
    @JsonProperty(value = "entry")
    RestRequestFieldsModel model;

    @JsonProperty(required = true)
    private String field;
    private String prefix;
    private String postfix;
    private Integer snippetCount;
    private Integer fragmentSize;
    private Boolean mergeContiguous;

    public RestRequestFieldsModel() {
        super();
    }

    public static RestRequestFieldsModel of(String field)
    {
        RestRequestFieldsModel fieldModel = new RestRequestFieldsModel();
        fieldModel.setField(field);
        return fieldModel;
    }

    public static RestRequestFieldsModel of(String field, String prefix, String postfix)
    {
        RestRequestFieldsModel fieldModel = new RestRequestFieldsModel();
        fieldModel.setField(field);
        fieldModel.setPrefix(prefix);
        fieldModel.setPostfix(postfix);
        return fieldModel;
    }

    @Override
    public RestRequestFieldsModel onModel()
    {
        return model;
    }

    public String getField()
    {
        return field;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getPostfix()
    {
        return postfix;
    }

    public void setPostfix(String postfix)
    {
        this.postfix = postfix;
    }

    public Integer getSnippetCount()
    {
        return snippetCount;
    }

    public void setSnippetCount(Integer snippetCount)
    {
        this.snippetCount = snippetCount;
    }

    public Integer getFragmentSize()
    {
        return fragmentSize;
    }

    public void setFragmentSize(Integer fragmentSize)
    {
        this.fragmentSize = fragmentSize;
    }

    public Boolean getMergeContiguous()
    {
        return mergeContiguous;
    }

    public void setMergeContiguous(Boolean mergeContiguous)
    {
        this.mergeContiguous = mergeContiguous;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private String field;
        private String prefix;
        private String postfix;
        private Integer snippetCount;
        private Integer fragmentSize;
        private Boolean mergeContiguous;

        public Builder field(String field)
        {
            this.field = field;
            return this;
        }

        public Builder prefix(String prefix)
        {
            this.prefix = prefix;
            return this;
        }

        public Builder postfix(String postfix)
        {
            this.postfix = postfix;
            return this;
        }

        public Builder snippetCount(Integer snippetCount)
        {
            this.snippetCount = snippetCount;
            return this;
        }
        public Builder fragmentSize(Integer fragmentSize)
        {
            this.fragmentSize = fragmentSize;
            return this;
        }

        public Builder mergeContiguous(Boolean mergeContiguous)
        {
            this.mergeContiguous = mergeContiguous;
            return this;
        }

        public RestRequestFieldsModel build()
        {
            RestRequestFieldsModel fieldModel = new RestRequestFieldsModel();
            fieldModel.setField(field);
            fieldModel.setPrefix(prefix);
            fieldModel.setPostfix(postfix);
            fieldModel.setSnippetCount(snippetCount);
            fieldModel.setFragmentSize(fragmentSize);
            fieldModel.setMergeContiguous(mergeContiguous);
            return fieldModel;
        }
    }
}

/*
 * Copyright (C) 2005-2014 Alfresco Software Limited.
 *
 * This file is part of Alfresco
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
 */
package org.alfresco.util.transaction;

import org.alfresco.error.AlfrescoRuntimeException;

/**
 * Exception wraps {@link java.util.NoSuchElementException} from {@link org.apache.commons.dbcp2.BasicDataSource}
 * 
 * @author alex.mukha
 * @since 4.1.9
 */
public class ConnectionPoolException extends AlfrescoRuntimeException
{
    private static final long serialVersionUID = 1L;

    public ConnectionPoolException(String msgId, Object[] msgParams, Throwable cause)
    {
        super(msgId, msgParams, cause);
    }

    public ConnectionPoolException(String msgId, Object[] msgParams)
    {
        super(msgId, msgParams);
    }

    public ConnectionPoolException(String msgId, Throwable cause)
    {
        super(msgId, cause);
    }

    public ConnectionPoolException(String msgId)
    {
        super(msgId);
    }
}

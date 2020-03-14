/*
 * Minio Java SDK for Amazon S3 Compatible Cloud Storage,
 * (C) 2019 Minio, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.minio.messages;

import com.google.api.client.util.Key;
import io.minio.Time;
import java.time.ZonedDateTime;
import org.xmlpull.v1.XmlPullParserException;

/** Helper class to parse Amazon AWS S3 response XML containing object item information. */
@SuppressWarnings({"SameParameterValue", "unused"})
public class CopyPartResult extends XmlEntity {
  @Key("ETag")
  private String etag;

  @Key("LastModified")
  private String lastModified;

  public CopyPartResult() throws XmlPullParserException {
    super();
    super.name = "CopyPartResult";
  }

  /** Returns last modified time of the object. */
  public ZonedDateTime lastModified() {
    return ZonedDateTime.parse(lastModified, Time.RESPONSE_DATE_FORMAT);
  }

  /** Returns ETag of the object. */
  public String etag() {
    return etag;
  }
}

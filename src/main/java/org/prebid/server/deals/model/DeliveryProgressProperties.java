package org.prebid.server.deals.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(staticName = "of")
@Value
public class DeliveryProgressProperties {

    long lineItemStatusTtlSeconds;

    int cachedPlansNumber;
}

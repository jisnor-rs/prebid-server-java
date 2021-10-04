package org.prebid.server.bidder.huaweiads.model.xnative;

public class ImageAssetType {

    private ImageAssetType() {
    }

    public static Integer imageAssetTypeIcon = 1; // Icon; Icon image; Optional. Max height: at least 50; aspect ratio: 1:1
    public static Integer imageAssetTypeLogo = 2; // Logo; Logo image for the brand/app. Deprecated in version 1.2 - use type 1 Icon.

    // Main; Large image preview for the ad. At least one of 2 size variants required:
    //   Small Variant:
    //     max height: at least 200
    //     max width: at least 200, 267, or 382
    //     aspect ratio: 1:1, 4:3, or 1.91:1
    //   Large Variant:
    //     max height: at least 627
    //     max width: at least 627, 836, or 1198
    //     aspect ratio: 1:1, 4:3, or 1.91:1
    public static Integer imageAssetTypeMain = 3;

    // 500+ XXX; Reserved for Exchange specific usage numbered above 500. No recommendations
}

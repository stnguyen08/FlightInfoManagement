package cs544.flight.domain;

public enum SiteUrl {
    HOME("/home"),
    AIR_LINES("/home/airlines"),
    AIR_PLANES("/home/airplanes");

    private String url;

    SiteUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}


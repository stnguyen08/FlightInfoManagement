package cs544.flight.domain;

public enum SiteUrl {
    HOME("/home"),
    AIR_LINES("/home/airlines");

    private String url;

    SiteUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}


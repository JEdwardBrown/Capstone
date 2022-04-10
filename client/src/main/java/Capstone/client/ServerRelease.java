package Capstone.client;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ServerRelease {
    private String name;
    private String url;

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetUrl() {
        return url;
    }

    public void SetUrl(String url) {
        this.url = url;
    }

}

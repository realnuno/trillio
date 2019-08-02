package com.Ian.trillio.entities;

import com.Ian.trillio.partner.Sharable;
import org.apache.commons.lang3.StringUtils;

public class WebLink extends Bookmark implements Sharable {
    private String url;
    private String host;
    private String htmlPage;
    private DownloadStatus downloadStatus = DownloadStatus.NOT_ATTEMTED;

    public enum DownloadStatus {
        NOT_ATTEMTED,
        SUCCESS,
        FAILED,
        NOT_ELIGIBLE;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public void setHtmlPage(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public String getHtmlPage() {
        return htmlPage;
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    @Override
    public boolean isKidsFriendlyEligible() {
        if(url.contains("porn") || getTitle().contains("porn") || host.contains("adult")) {
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>WebLink</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<url>").append(url).append("</url>");
        builder.append("<host>").append(host).append("</host>");
        builder.append("</item>");

        return builder.toString();
    }
}
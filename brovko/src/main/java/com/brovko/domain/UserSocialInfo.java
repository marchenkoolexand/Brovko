package com.brovko.domain;

import javax.persistence.*;

@Entity
@Table(name = "br_user_social_info")
public class UserSocialInfo {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private Long id;
    @Column(name = "br_fb_link")
    private String facebookLink;
    @Column(name = "br_skype")
    private String skype;
    @Column(name = "br_vk_link")
    private String vkLink;
    @Column(name = "br_gp_link")
    private String googlePlusLink;
    @Column(name = "br_tw_link")
    private String twitterLink;
    @Column(name = "br_icq_number")
    private int icqNumber;

    public UserSocialInfo() {
    }

    public UserSocialInfo(String facebookLink, String skype, String vkLink, String googlePlusLink, String twitterLink, int icqNumber) {
        this.facebookLink = facebookLink;
        this.skype = skype;
        this.vkLink = vkLink;
        this.googlePlusLink = googlePlusLink;
        this.twitterLink = twitterLink;
        this.icqNumber = icqNumber;
    }

    public Long getId() {
        return id;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getVkLink() {
        return vkLink;
    }

    public void setVkLink(String vkLink) {
        this.vkLink = vkLink;
    }

    public String getGooglePlusLink() {
        return googlePlusLink;
    }

    public void setGooglePlusLink(String googlePlusLink) {
        this.googlePlusLink = googlePlusLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public int getIcqNumber() {
        return icqNumber;
    }

    public void setIcqNumber(int icqNumber) {
        this.icqNumber = icqNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSocialInfo that = (UserSocialInfo) o;

        if (icqNumber != that.icqNumber) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (facebookLink != null ? !facebookLink.equals(that.facebookLink) : that.facebookLink != null) return false;
        if (skype != null ? !skype.equals(that.skype) : that.skype != null) return false;
        if (vkLink != null ? !vkLink.equals(that.vkLink) : that.vkLink != null) return false;
        if (googlePlusLink != null ? !googlePlusLink.equals(that.googlePlusLink) : that.googlePlusLink != null)
            return false;
        return twitterLink != null ? twitterLink.equals(that.twitterLink) : that.twitterLink == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (facebookLink != null ? facebookLink.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (vkLink != null ? vkLink.hashCode() : 0);
        result = 31 * result + (googlePlusLink != null ? googlePlusLink.hashCode() : 0);
        result = 31 * result + (twitterLink != null ? twitterLink.hashCode() : 0);
        result = 31 * result + icqNumber;
        return result;
    }

    @Override
    public String toString() {
        return "UserSocialInfo{" +
                "id=" + id +
                ", facebookLink='" + facebookLink + '\'' +
                ", skype='" + skype + '\'' +
                ", vkLink='" + vkLink + '\'' +
                ", googlePlusLink='" + googlePlusLink + '\'' +
                ", twitterLink='" + twitterLink + '\'' +
                ", icqNumber=" + icqNumber +
                '}';
    }
}

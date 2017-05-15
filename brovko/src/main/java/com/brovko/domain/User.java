package com.brovko.domain;

import com.brovko.converters.IntArrayToStringConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "br_users")
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private Long id;
    @Column(name = "br_avatar_id")
    private int avatarId;
    @Column(name = "br_email", unique = true, nullable = false, length = 45)
    private String email;
    @Column(name = "br_password", nullable = false, length = 65)
    private String passwordHash;
    //@JoinTable(name = "br_roles", joinColumns = @JoinColumn(name = "br_user_id"))
    //@ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @Column(name = "br_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "br_first_name")
    private String firstName;
    @Column(name = "br_last_name")
    private String lastName;
    @Column(name = "br_recovery_email", nullable = false, length = 45)
    private String recoveryEmail;
    @Column(name = "br_phone_number")
    private String phoneNumber;
    @Column(name = "br_enabled")
    private boolean enabled;
    @Column(name = "br_pref_lang")
    private String userPreferedLanguage;
    @Column(name = "br_user_sex")
    private Sex sex;
    @Column(name = "br_birth_date")
    private LocalDateTime dateOfBirth;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private UserSocialInfo userSocialInfo;
    @Column(name = "br_about")
    private String aboutYourSelf;
    @Column
    @Convert(converter = IntArrayToStringConverter.class)
    private List<Integer> favoriteProductIds;

    public User() {
    }

    public User(int avatarId, String email, String passwordHash, String firstName, String lastName, String recoveryEmail, String phoneNumber, boolean enabled, String userPreferedLanguage, Sex sex, LocalDateTime dateOfBirth, UserSocialInfo userSocialInfo, String aboutYourSelf, List<Integer> favoriteProductIds) {
        this.avatarId = avatarId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.recoveryEmail = recoveryEmail;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.userPreferedLanguage = userPreferedLanguage;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.userSocialInfo = userSocialInfo;
        this.aboutYourSelf = aboutYourSelf;
        this.favoriteProductIds = favoriteProductIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserPreferedLanguage() {
        return userPreferedLanguage;
    }

    public void setUserPreferedLanguage(String userPreferedLanguage) {
        this.userPreferedLanguage = userPreferedLanguage;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserSocialInfo getUserSocialInfo() {
        return userSocialInfo;
    }

    public void setUserSocialInfo(UserSocialInfo userSocialInfo) {
        this.userSocialInfo = userSocialInfo;
    }

    public String getAboutYourSelf() {
        return aboutYourSelf;
    }

    public void setAboutYourSelf(String aboutYourSelf) {
        this.aboutYourSelf = aboutYourSelf;
    }

    public List<Integer> getFavoriteProductIds() {
        return favoriteProductIds;
    }

    public void setFavoriteProductIds(List<Integer> favoriteProductIds) {
        this.favoriteProductIds = favoriteProductIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (avatarId != user.avatarId) return false;
        if (enabled != user.enabled) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (passwordHash != null ? !passwordHash.equals(user.passwordHash) : user.passwordHash != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (recoveryEmail != null ? !recoveryEmail.equals(user.recoveryEmail) : user.recoveryEmail != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (userPreferedLanguage != null ? !userPreferedLanguage.equals(user.userPreferedLanguage) : user.userPreferedLanguage != null)
            return false;
        if (sex != user.sex) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth != null) return false;
        if (userSocialInfo != null ? !userSocialInfo.equals(user.userSocialInfo) : user.userSocialInfo != null)
            return false;
        if (aboutYourSelf != null ? !aboutYourSelf.equals(user.aboutYourSelf) : user.aboutYourSelf != null)
            return false;
        return favoriteProductIds != null ? favoriteProductIds.equals(user.favoriteProductIds) : user.favoriteProductIds == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + avatarId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (recoveryEmail != null ? recoveryEmail.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (userPreferedLanguage != null ? userPreferedLanguage.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (userSocialInfo != null ? userSocialInfo.hashCode() : 0);
        result = 31 * result + (aboutYourSelf != null ? aboutYourSelf.hashCode() : 0);
        result = 31 * result + (favoriteProductIds != null ? favoriteProductIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatarId=" + avatarId +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", recoveryEmail='" + recoveryEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", enabled=" + enabled +
                ", userPreferedLanguage='" + userPreferedLanguage + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", userSocialInfo=" + userSocialInfo +
                ", aboutYourSelf='" + aboutYourSelf + '\'' +
                ", favoriteProductIds=" + favoriteProductIds +
                '}';
    }
}

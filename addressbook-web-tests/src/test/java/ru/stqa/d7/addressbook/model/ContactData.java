package ru.stqa.d7.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String nickname;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String email;

  public ContactData(String firstname, String middlename, String nickname, String company, String address, String home, String mobile, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }
}

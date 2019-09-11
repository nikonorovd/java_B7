package ru.stqa.d7.addressbook.model;

public class ContactData {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String nickname;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String email;
  private String group;


  public ContactData(String firstname, String middlename, String nickname, String company, String address, String home, String mobile, String email, String group ) {
    this.id = 0;
    this.firstname = firstname;
    this.middlename = middlename;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id,String firstname, String middlename, String nickname, String company, String address, String home, String mobile, String email, String group ) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            '}';
  }

}

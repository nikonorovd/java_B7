package ru.stqa.d7.addressbook.model;

public class ContactData {
  private final String id;
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
    this.id = null;
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

  public ContactData(String id,String firstname, String middlename, String nickname, String company, String address, String home, String mobile, String email, String group ) {
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

  public String getId() {
    return id;
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
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals( that.id ) : that.id != null) return false;
    return firstname != null ? firstname.equals( that.firstname ) : that.firstname == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    return result;
  }
}

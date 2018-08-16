/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Itsexceptional
 */
@Entity
@Table(name = "employee", catalog = "bugdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmpId", query = "SELECT e FROM Employee e WHERE e.empId = :empId")
    , @NamedQuery(name = "Employee.findByEmpName", query = "SELECT e FROM Employee e WHERE e.empName = :empName")
    , @NamedQuery(name = "Employee.findByPass", query = "SELECT e FROM Employee e WHERE e.pass = :pass")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee.findByEmailId", query = "SELECT e FROM Employee e WHERE e.emailId = :emailId")
    , @NamedQuery(name = "Employee.findByEmpCity", query = "SELECT e FROM Employee e WHERE e.empCity = :empCity")
    , @NamedQuery(name = "Employee.findByEmpContact", query = "SELECT e FROM Employee e WHERE e.empContact = :empContact")
    , @NamedQuery(name = "Employee.findByRole", query = "SELECT e FROM Employee e WHERE e.role = :role")
    , @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")
    , @NamedQuery(name = "Employee.findByResult", query = "SELECT e FROM Employee e WHERE e.result = :result")})
public class Employee implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "pass")
    private String pass;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "emp_city")
    private String empCity;
    @Column(name = "emp_contact")
    private String empContact;
    @Column(name = "role")
    private String role;
    @Lob
    @Column(name = "images")
    private byte[] images;
    @Column(name = "status")
    private String status;
    @Column(name = "result")
    private String result;

    public Employee() {
    }

    public Employee(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        Integer oldEmpId = this.empId;
        this.empId = empId;
        changeSupport.firePropertyChange("empId", oldEmpId, empId);
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        String oldEmpName = this.empName;
        this.empName = empName;
        changeSupport.firePropertyChange("empName", oldEmpName, empName);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        String oldPass = this.pass;
        this.pass = pass;
        changeSupport.firePropertyChange("pass", oldPass, pass);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        String oldEmailId = this.emailId;
        this.emailId = emailId;
        changeSupport.firePropertyChange("emailId", oldEmailId, emailId);
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        String oldEmpCity = this.empCity;
        this.empCity = empCity;
        changeSupport.firePropertyChange("empCity", oldEmpCity, empCity);
    }

    public String getEmpContact() {
        return empContact;
    }

    public void setEmpContact(String empContact) {
        String oldEmpContact = this.empContact;
        this.empContact = empContact;
        changeSupport.firePropertyChange("empContact", oldEmpContact, empContact);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        String oldRole = this.role;
        this.role = role;
        changeSupport.firePropertyChange("role", oldRole, role);
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        byte[] oldImages = this.images;
        this.images = images;
        changeSupport.firePropertyChange("images", oldImages, images);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        String oldResult = this.result;
        this.result = result;
        changeSupport.firePropertyChange("result", oldResult, result);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Admin_Data.Employee[ empId=" + empId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

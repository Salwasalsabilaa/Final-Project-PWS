/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.PWS;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inspiron
 */
@Entity
@Table(name = "penduduk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penduduk.findAll", query = "SELECT p FROM Penduduk p"),
    @NamedQuery(name = "Penduduk.findById", query = "SELECT p FROM Penduduk p WHERE p.id = :id"),
    @NamedQuery(name = "Penduduk.findByNama", query = "SELECT p FROM Penduduk p WHERE p.nama = :nama"),
    @NamedQuery(name = "Penduduk.findByNik", query = "SELECT p FROM Penduduk p WHERE p.nik = :nik"),
    @NamedQuery(name = "Penduduk.findByAddress", query = "SELECT p FROM Penduduk p WHERE p.address = :address")})
public class Penduduk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Nama")
    private String nama;
    @Column(name = "NIK")
    private Integer nik;
    @Column(name = "Address")
    private String address;
    @Lob
    @Column(name = "picture")
    private byte[] picture;

    public Penduduk() {
    }

    public Penduduk(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penduduk)) {
            return false;
        }
        Penduduk other = (Penduduk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FinalProject.PWS.Penduduk[ id=" + id + " ]";
    }
    
}

package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Ban {
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Id
       @Column(name = "Id")
       private int id;
       @Basic
       @Column(name = "Ma")
       private String ma;
       @Basic
       @Column(name = "Ten")
       private String ten;
       @Basic
       @Column(name = "NgaySinh")
       private Date ngaySinh;
       @Basic
       @Column(name = "SoThich")
       private String soThich;
       @Basic
       @Column(name = "GioiTinh")
       private Integer gioiTinh;
       @ManyToOne
       @JoinColumn(name = "IdMQH")
       private MoiQuanHe idMqh;
       @Basic
       @Column(name = "TrangThai")
       private Integer trangThai;

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getMa() {
              return ma;
       }

       public void setMa(String ma) {
              this.ma = ma;
       }

       public String getTen() {
              return ten;
       }

       public void setTen(String ten) {
              this.ten = ten;
       }

       public Date getNgaySinh() {
              return ngaySinh;
       }

       public void setNgaySinh(Date ngaySinh) {
              this.ngaySinh = ngaySinh;
       }

       public String getSoThich() {
              return soThich;
       }

       public void setSoThich(String soThich) {
              this.soThich = soThich;
       }

       public Integer getGioiTinh() {
              return gioiTinh;
       }

       public void setGioiTinh(Integer gioiTinh) {
              this.gioiTinh = gioiTinh;
       }

       public MoiQuanHe getIdMqh() {
              return idMqh;
       }

       public void setIdMqh(MoiQuanHe idMqh) {
              this.idMqh = idMqh;
       }

       public Integer getTrangThai() {
              return trangThai;
       }

       public void setTrangThai(Integer trangThai) {
              this.trangThai = trangThai;
       }

       @Override
       public boolean equals(Object o) {
              if (this == o)
                     return true;
              if (o == null || getClass() != o.getClass())
                     return false;

              Ban ban = (Ban) o;

              if (id != ban.id)
                     return false;
              if (!Objects.equals(ma, ban.ma))
                     return false;
              if (!Objects.equals(ten, ban.ten))
                     return false;
              if (!Objects.equals(ngaySinh, ban.ngaySinh))
                     return false;
              if (!Objects.equals(soThich, ban.soThich))
                     return false;
              if (!Objects.equals(gioiTinh, ban.gioiTinh))
                     return false;
              if (!Objects.equals(idMqh, ban.idMqh))
                     return false;
              if (!Objects.equals(trangThai, ban.trangThai))
                     return false;

              return true;
       }

       @Override
       public int hashCode() {
              int result = id;
              result = 31 * result + (ma != null ? ma.hashCode() : 0);
              result = 31 * result + (ten != null ? ten.hashCode() : 0);
              result = 31 * result + (ngaySinh != null ? ngaySinh.hashCode() : 0);
              result = 31 * result + (soThich != null ? soThich.hashCode() : 0);
              result = 31 * result + (gioiTinh != null ? gioiTinh.hashCode() : 0);
              result = 31 * result + (idMqh != null ? idMqh.hashCode() : 0);
              result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
              return result;
       }

       public Ban(String ma, String ten, Date ngaySinh, String soThich, Integer gioiTinh, MoiQuanHe idMqh, Integer trangThai) {
              this.ma = ma;
              this.ten = ten;
              this.ngaySinh = ngaySinh;
              this.soThich = soThich;
              this.gioiTinh = gioiTinh;
              this.idMqh = idMqh;
              this.trangThai = trangThai;
       }
}

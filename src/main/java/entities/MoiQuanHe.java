package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class MoiQuanHe {
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

       @Override
       public boolean equals(Object o) {
              if (this == o)
                     return true;
              if (o == null || getClass() != o.getClass())
                     return false;

              MoiQuanHe moiQuanHe = (MoiQuanHe) o;

              if (id != moiQuanHe.id)
                     return false;
              if (!Objects.equals(ma, moiQuanHe.ma))
                     return false;
              if (!Objects.equals(ten, moiQuanHe.ten))
                     return false;

              return true;
       }

       @Override
       public int hashCode() {
              int result = id;
              result = 31 * result + (ma != null ? ma.hashCode() : 0);
              result = 31 * result + (ten != null ? ten.hashCode() : 0);
              return result;
       }
}

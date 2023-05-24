package cgd.rampupcgd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalRandomObject {

  private int userId;
  private int id;
  private String title;
  private boolean completed;



}

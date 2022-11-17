package taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Driver {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String licenseNumber;
    @NonNull
    private String login;
    @NonNull
    @ToString.Exclude
    private transient String password;
}

package taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Manufacturer {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String country;
}

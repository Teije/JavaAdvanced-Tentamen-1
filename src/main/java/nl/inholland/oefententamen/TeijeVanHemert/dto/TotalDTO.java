package nl.inholland.oefententamen.TeijeVanHemert.dto;

import lombok.Data;

@Data
public class TotalDTO
{
    private int total;

    public TotalDTO(int total)
    {
        this.total = total;
    }
}

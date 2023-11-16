package christmas.domain.dto;

import christmas.constants.StringConstants;
import christmas.domain.discounts.Discount;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscountDto {
    private final String discounts;

    private DiscountDto(final Map<Discount, Integer> discount) {
        if (discount.size() == 0) {
            this.discounts = StringConstants.NOTHING;
            return;
        }
        this.discounts = discount.entrySet().stream().map(item -> item.getKey().getDiscountString()).collect(
                Collectors.joining(StringConstants.ENTER));
    }

    public static DiscountDto fromDiscount(Map<Discount, Integer> discount) {
        return new DiscountDto(discount);
    }

    public String getTotalDiscount() {
        return this.discounts;
    }
}

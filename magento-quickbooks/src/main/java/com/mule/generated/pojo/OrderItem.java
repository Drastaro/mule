package com.mule.generated.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class OrderItem {

	@SerializedName("item_id")
	@Expose
	private String itemId;
	@SerializedName("parent_item_id")
	@Expose
	private Object parentItemId;
	@SerializedName("sku")
	@Expose
	private String sku;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("qty_canceled")
	@Expose
	private String qtyCanceled;
	@SerializedName("qty_invoiced")
	@Expose
	private String qtyInvoiced;
	@SerializedName("qty_ordered")
	@Expose
	private String qtyOrdered;
	@SerializedName("qty_refunded")
	@Expose
	private String qtyRefunded;
	@SerializedName("qty_shipped")
	@Expose
	private String qtyShipped;
	@SerializedName("price")
	@Expose
	private String price;
	@SerializedName("base_price")
	@Expose
	private String basePrice;
	@SerializedName("original_price")
	@Expose
	private String originalPrice;
	@SerializedName("base_original_price")
	@Expose
	private String baseOriginalPrice;
	@SerializedName("tax_percent")
	@Expose
	private String taxPercent;
	@SerializedName("tax_amount")
	@Expose
	private String taxAmount;
	@SerializedName("base_tax_amount")
	@Expose
	private String baseTaxAmount;
	@SerializedName("discount_amount")
	@Expose
	private String discountAmount;
	@SerializedName("base_discount_amount")
	@Expose
	private String baseDiscountAmount;
	@SerializedName("row_total")
	@Expose
	private String rowTotal;
	@SerializedName("base_row_total")
	@Expose
	private String baseRowTotal;
	@SerializedName("price_incl_tax")
	@Expose
	private String priceInclTax;
	@SerializedName("base_price_incl_tax")
	@Expose
	private String basePriceInclTax;
	@SerializedName("row_total_incl_tax")
	@Expose
	private String rowTotalInclTax;
	@SerializedName("base_row_total_incl_tax")
	@Expose
	private String baseRowTotalInclTax;

	/**
	 * 
	 * @return The itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * 
	 * @param itemId
	 *            The item_id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public OrderItem withItemId(String itemId) {
		this.itemId = itemId;
		return this;
	}

	/**
	 * 
	 * @return The parentItemId
	 */
	public Object getParentItemId() {
		return parentItemId;
	}

	/**
	 * 
	 * @param parentItemId
	 *            The parent_item_id
	 */
	public void setParentItemId(Object parentItemId) {
		this.parentItemId = parentItemId;
	}

	public OrderItem withParentItemId(Object parentItemId) {
		this.parentItemId = parentItemId;
		return this;
	}

	/**
	 * 
	 * @return The sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * 
	 * @param sku
	 *            The sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	public OrderItem withSku(String sku) {
		this.sku = sku;
		return this;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public OrderItem withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The qtyCanceled
	 */
	public String getQtyCanceled() {
		return qtyCanceled;
	}

	/**
	 * 
	 * @param qtyCanceled
	 *            The qty_canceled
	 */
	public void setQtyCanceled(String qtyCanceled) {
		this.qtyCanceled = qtyCanceled;
	}

	public OrderItem withQtyCanceled(String qtyCanceled) {
		this.qtyCanceled = qtyCanceled;
		return this;
	}

	/**
	 * 
	 * @return The qtyInvoiced
	 */
	public String getQtyInvoiced() {
		return qtyInvoiced;
	}

	/**
	 * 
	 * @param qtyInvoiced
	 *            The qty_invoiced
	 */
	public void setQtyInvoiced(String qtyInvoiced) {
		this.qtyInvoiced = qtyInvoiced;
	}

	public OrderItem withQtyInvoiced(String qtyInvoiced) {
		this.qtyInvoiced = qtyInvoiced;
		return this;
	}

	/**
	 * 
	 * @return The qtyOrdered
	 */
	public String getQtyOrdered() {
		return qtyOrdered;
	}

	/**
	 * 
	 * @param qtyOrdered
	 *            The qty_ordered
	 */
	public void setQtyOrdered(String qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public OrderItem withQtyOrdered(String qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
		return this;
	}

	/**
	 * 
	 * @return The qtyRefunded
	 */
	public String getQtyRefunded() {
		return qtyRefunded;
	}

	/**
	 * 
	 * @param qtyRefunded
	 *            The qty_refunded
	 */
	public void setQtyRefunded(String qtyRefunded) {
		this.qtyRefunded = qtyRefunded;
	}

	public OrderItem withQtyRefunded(String qtyRefunded) {
		this.qtyRefunded = qtyRefunded;
		return this;
	}

	/**
	 * 
	 * @return The qtyShipped
	 */
	public String getQtyShipped() {
		return qtyShipped;
	}

	/**
	 * 
	 * @param qtyShipped
	 *            The qty_shipped
	 */
	public void setQtyShipped(String qtyShipped) {
		this.qtyShipped = qtyShipped;
	}

	public OrderItem withQtyShipped(String qtyShipped) {
		this.qtyShipped = qtyShipped;
		return this;
	}

	/**
	 * 
	 * @return The price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 *            The price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	public OrderItem withPrice(String price) {
		this.price = price;
		return this;
	}

	/**
	 * 
	 * @return The basePrice
	 */
	public String getBasePrice() {
		return basePrice;
	}

	/**
	 * 
	 * @param basePrice
	 *            The base_price
	 */
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public OrderItem withBasePrice(String basePrice) {
		this.basePrice = basePrice;
		return this;
	}

	/**
	 * 
	 * @return The originalPrice
	 */
	public String getOriginalPrice() {
		return originalPrice;
	}

	/**
	 * 
	 * @param originalPrice
	 *            The original_price
	 */
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public OrderItem withOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
		return this;
	}

	/**
	 * 
	 * @return The baseOriginalPrice
	 */
	public String getBaseOriginalPrice() {
		return baseOriginalPrice;
	}

	/**
	 * 
	 * @param baseOriginalPrice
	 *            The base_original_price
	 */
	public void setBaseOriginalPrice(String baseOriginalPrice) {
		this.baseOriginalPrice = baseOriginalPrice;
	}

	public OrderItem withBaseOriginalPrice(String baseOriginalPrice) {
		this.baseOriginalPrice = baseOriginalPrice;
		return this;
	}

	/**
	 * 
	 * @return The taxPercent
	 */
	public String getTaxPercent() {
		return taxPercent;
	}

	/**
	 * 
	 * @param taxPercent
	 *            The tax_percent
	 */
	public void setTaxPercent(String taxPercent) {
		this.taxPercent = taxPercent;
	}

	public OrderItem withTaxPercent(String taxPercent) {
		this.taxPercent = taxPercent;
		return this;
	}

	/**
	 * 
	 * @return The taxAmount
	 */
	public String getTaxAmount() {
		return taxAmount;
	}

	/**
	 * 
	 * @param taxAmount
	 *            The tax_amount
	 */
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public OrderItem withTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseTaxAmount
	 */
	public String getBaseTaxAmount() {
		return baseTaxAmount;
	}

	/**
	 * 
	 * @param baseTaxAmount
	 *            The base_tax_amount
	 */
	public void setBaseTaxAmount(String baseTaxAmount) {
		this.baseTaxAmount = baseTaxAmount;
	}

	public OrderItem withBaseTaxAmount(String baseTaxAmount) {
		this.baseTaxAmount = baseTaxAmount;
		return this;
	}

	/**
	 * 
	 * @return The discountAmount
	 */
	public String getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * 
	 * @param discountAmount
	 *            The discount_amount
	 */
	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public OrderItem withDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseDiscountAmount
	 */
	public String getBaseDiscountAmount() {
		return baseDiscountAmount;
	}

	/**
	 * 
	 * @param baseDiscountAmount
	 *            The base_discount_amount
	 */
	public void setBaseDiscountAmount(String baseDiscountAmount) {
		this.baseDiscountAmount = baseDiscountAmount;
	}

	public OrderItem withBaseDiscountAmount(String baseDiscountAmount) {
		this.baseDiscountAmount = baseDiscountAmount;
		return this;
	}

	/**
	 * 
	 * @return The rowTotal
	 */
	public String getRowTotal() {
		return rowTotal;
	}

	/**
	 * 
	 * @param rowTotal
	 *            The row_total
	 */
	public void setRowTotal(String rowTotal) {
		this.rowTotal = rowTotal;
	}

	public OrderItem withRowTotal(String rowTotal) {
		this.rowTotal = rowTotal;
		return this;
	}

	/**
	 * 
	 * @return The baseRowTotal
	 */
	public String getBaseRowTotal() {
		return baseRowTotal;
	}

	/**
	 * 
	 * @param baseRowTotal
	 *            The base_row_total
	 */
	public void setBaseRowTotal(String baseRowTotal) {
		this.baseRowTotal = baseRowTotal;
	}

	public OrderItem withBaseRowTotal(String baseRowTotal) {
		this.baseRowTotal = baseRowTotal;
		return this;
	}

	/**
	 * 
	 * @return The priceInclTax
	 */
	public String getPriceInclTax() {
		return priceInclTax;
	}

	/**
	 * 
	 * @param priceInclTax
	 *            The price_incl_tax
	 */
	public void setPriceInclTax(String priceInclTax) {
		this.priceInclTax = priceInclTax;
	}

	public OrderItem withPriceInclTax(String priceInclTax) {
		this.priceInclTax = priceInclTax;
		return this;
	}

	/**
	 * 
	 * @return The basePriceInclTax
	 */
	public String getBasePriceInclTax() {
		return basePriceInclTax;
	}

	/**
	 * 
	 * @param basePriceInclTax
	 *            The base_price_incl_tax
	 */
	public void setBasePriceInclTax(String basePriceInclTax) {
		this.basePriceInclTax = basePriceInclTax;
	}

	public OrderItem withBasePriceInclTax(String basePriceInclTax) {
		this.basePriceInclTax = basePriceInclTax;
		return this;
	}

	/**
	 * 
	 * @return The rowTotalInclTax
	 */
	public String getRowTotalInclTax() {
		return rowTotalInclTax;
	}

	/**
	 * 
	 * @param rowTotalInclTax
	 *            The row_total_incl_tax
	 */
	public void setRowTotalInclTax(String rowTotalInclTax) {
		this.rowTotalInclTax = rowTotalInclTax;
	}

	public OrderItem withRowTotalInclTax(String rowTotalInclTax) {
		this.rowTotalInclTax = rowTotalInclTax;
		return this;
	}

	/**
	 * 
	 * @return The baseRowTotalInclTax
	 */
	public String getBaseRowTotalInclTax() {
		return baseRowTotalInclTax;
	}

	/**
	 * 
	 * @param baseRowTotalInclTax
	 *            The base_row_total_incl_tax
	 */
	public void setBaseRowTotalInclTax(String baseRowTotalInclTax) {
		this.baseRowTotalInclTax = baseRowTotalInclTax;
	}

	public OrderItem withBaseRowTotalInclTax(String baseRowTotalInclTax) {
		this.baseRowTotalInclTax = baseRowTotalInclTax;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

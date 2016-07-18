package com.mule.generated.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class OrdersEntity {

	@SerializedName("entity_id")
	@Expose
	private String entityId;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("coupon_code")
	@Expose
	private Object couponCode;
	@SerializedName("shipping_description")
	@Expose
	private String shippingDescription;
	@SerializedName("customer_id")
	@Expose
	private String customerId;
	@SerializedName("base_discount_amount")
	@Expose
	private String baseDiscountAmount;
	@SerializedName("base_grand_total")
	@Expose
	private String baseGrandTotal;
	@SerializedName("base_shipping_amount")
	@Expose
	private String baseShippingAmount;
	@SerializedName("base_shipping_tax_amount")
	@Expose
	private String baseShippingTaxAmount;
	@SerializedName("base_subtotal")
	@Expose
	private String baseSubtotal;
	@SerializedName("base_tax_amount")
	@Expose
	private String baseTaxAmount;
	@SerializedName("base_total_paid")
	@Expose
	private Object baseTotalPaid;
	@SerializedName("base_total_refunded")
	@Expose
	private Object baseTotalRefunded;
	@SerializedName("discount_amount")
	@Expose
	private String discountAmount;
	@SerializedName("grand_total")
	@Expose
	private String grandTotal;
	@SerializedName("shipping_amount")
	@Expose
	private String shippingAmount;
	@SerializedName("shipping_tax_amount")
	@Expose
	private String shippingTaxAmount;
	@SerializedName("store_to_order_rate")
	@Expose
	private String storeToOrderRate;
	@SerializedName("subtotal")
	@Expose
	private String subtotal;
	@SerializedName("tax_amount")
	@Expose
	private String taxAmount;
	@SerializedName("total_paid")
	@Expose
	private Object totalPaid;
	@SerializedName("total_refunded")
	@Expose
	private Object totalRefunded;
	@SerializedName("base_shipping_discount_amount")
	@Expose
	private String baseShippingDiscountAmount;
	@SerializedName("base_subtotal_incl_tax")
	@Expose
	private String baseSubtotalInclTax;
	@SerializedName("base_total_due")
	@Expose
	private Object baseTotalDue;
	@SerializedName("shipping_discount_amount")
	@Expose
	private String shippingDiscountAmount;
	@SerializedName("subtotal_incl_tax")
	@Expose
	private String subtotalInclTax;
	@SerializedName("total_due")
	@Expose
	private Object totalDue;
	@SerializedName("increment_id")
	@Expose
	private String incrementId;
	@SerializedName("base_currency_code")
	@Expose
	private String baseCurrencyCode;
	@SerializedName("discount_description")
	@Expose
	private Object discountDescription;
	@SerializedName("remote_ip")
	@Expose
	private Object remoteIp;
	@SerializedName("store_currency_code")
	@Expose
	private String storeCurrencyCode;
	@SerializedName("store_name")
	@Expose
	private String storeName;
	@SerializedName("created_at")
	@Expose
	private String createdAt;
	@SerializedName("shipping_incl_tax")
	@Expose
	private String shippingInclTax;
	@SerializedName("base_customer_balance_amount")
	@Expose
	private Object baseCustomerBalanceAmount;
	@SerializedName("customer_balance_amount")
	@Expose
	private Object customerBalanceAmount;
	@SerializedName("payment_method")
	@Expose
	private String paymentMethod;
	@SerializedName("gift_message_from")
	@Expose
	private String giftMessageFrom;
	@SerializedName("gift_message_to")
	@Expose
	private String giftMessageTo;
	@SerializedName("gift_message_body")
	@Expose
	private String giftMessageBody;
	@SerializedName("tax_name")
	@Expose
	private Object taxName;
	@SerializedName("tax_rate")
	@Expose
	private Object taxRate;
	@SerializedName("addresses")
	@Expose
	private List<Address> addresses = new ArrayList<Address>();
	@SerializedName("order_items")
	@Expose
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	@SerializedName("order_comments")
	@Expose
	private List<OrderComment> orderComments = new ArrayList<OrderComment>();

	/**
	 * 
	 * @return The entityId
	 */
	public String getEntityId() {
		return entityId;
	}

	/**
	 * 
	 * @param entityId
	 *            The entity_id
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public OrdersEntity withEntityId(String entityId) {
		this.entityId = entityId;
		return this;
	}

	/**
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public OrdersEntity withStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * 
	 * @return The couponCode
	 */
	public Object getCouponCode() {
		return couponCode;
	}

	/**
	 * 
	 * @param couponCode
	 *            The coupon_code
	 */
	public void setCouponCode(Object couponCode) {
		this.couponCode = couponCode;
	}

	public OrdersEntity withCouponCode(Object couponCode) {
		this.couponCode = couponCode;
		return this;
	}

	/**
	 * 
	 * @return The shippingDescription
	 */
	public String getShippingDescription() {
		return shippingDescription;
	}

	/**
	 * 
	 * @param shippingDescription
	 *            The shipping_description
	 */
	public void setShippingDescription(String shippingDescription) {
		this.shippingDescription = shippingDescription;
	}

	public OrdersEntity withShippingDescription(String shippingDescription) {
		this.shippingDescription = shippingDescription;
		return this;
	}

	/**
	 * 
	 * @return The customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 *            The customer_id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public OrdersEntity withCustomerId(String customerId) {
		this.customerId = customerId;
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

	public OrdersEntity withBaseDiscountAmount(String baseDiscountAmount) {
		this.baseDiscountAmount = baseDiscountAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseGrandTotal
	 */
	public String getBaseGrandTotal() {
		return baseGrandTotal;
	}

	/**
	 * 
	 * @param baseGrandTotal
	 *            The base_grand_total
	 */
	public void setBaseGrandTotal(String baseGrandTotal) {
		this.baseGrandTotal = baseGrandTotal;
	}

	public OrdersEntity withBaseGrandTotal(String baseGrandTotal) {
		this.baseGrandTotal = baseGrandTotal;
		return this;
	}

	/**
	 * 
	 * @return The baseShippingAmount
	 */
	public String getBaseShippingAmount() {
		return baseShippingAmount;
	}

	/**
	 * 
	 * @param baseShippingAmount
	 *            The base_shipping_amount
	 */
	public void setBaseShippingAmount(String baseShippingAmount) {
		this.baseShippingAmount = baseShippingAmount;
	}

	public OrdersEntity withBaseShippingAmount(String baseShippingAmount) {
		this.baseShippingAmount = baseShippingAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseShippingTaxAmount
	 */
	public String getBaseShippingTaxAmount() {
		return baseShippingTaxAmount;
	}

	/**
	 * 
	 * @param baseShippingTaxAmount
	 *            The base_shipping_tax_amount
	 */
	public void setBaseShippingTaxAmount(String baseShippingTaxAmount) {
		this.baseShippingTaxAmount = baseShippingTaxAmount;
	}

	public OrdersEntity withBaseShippingTaxAmount(String baseShippingTaxAmount) {
		this.baseShippingTaxAmount = baseShippingTaxAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseSubtotal
	 */
	public String getBaseSubtotal() {
		return baseSubtotal;
	}

	/**
	 * 
	 * @param baseSubtotal
	 *            The base_subtotal
	 */
	public void setBaseSubtotal(String baseSubtotal) {
		this.baseSubtotal = baseSubtotal;
	}

	public OrdersEntity withBaseSubtotal(String baseSubtotal) {
		this.baseSubtotal = baseSubtotal;
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

	public OrdersEntity withBaseTaxAmount(String baseTaxAmount) {
		this.baseTaxAmount = baseTaxAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseTotalPaid
	 */
	public Object getBaseTotalPaid() {
		return baseTotalPaid;
	}

	/**
	 * 
	 * @param baseTotalPaid
	 *            The base_total_paid
	 */
	public void setBaseTotalPaid(Object baseTotalPaid) {
		this.baseTotalPaid = baseTotalPaid;
	}

	public OrdersEntity withBaseTotalPaid(Object baseTotalPaid) {
		this.baseTotalPaid = baseTotalPaid;
		return this;
	}

	/**
	 * 
	 * @return The baseTotalRefunded
	 */
	public Object getBaseTotalRefunded() {
		return baseTotalRefunded;
	}

	/**
	 * 
	 * @param baseTotalRefunded
	 *            The base_total_refunded
	 */
	public void setBaseTotalRefunded(Object baseTotalRefunded) {
		this.baseTotalRefunded = baseTotalRefunded;
	}

	public OrdersEntity withBaseTotalRefunded(Object baseTotalRefunded) {
		this.baseTotalRefunded = baseTotalRefunded;
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

	public OrdersEntity withDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
		return this;
	}

	/**
	 * 
	 * @return The grandTotal
	 */
	public String getGrandTotal() {
		return grandTotal;
	}

	/**
	 * 
	 * @param grandTotal
	 *            The grand_total
	 */
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public OrdersEntity withGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
		return this;
	}

	/**
	 * 
	 * @return The shippingAmount
	 */
	public String getShippingAmount() {
		return shippingAmount;
	}

	/**
	 * 
	 * @param shippingAmount
	 *            The shipping_amount
	 */
	public void setShippingAmount(String shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public OrdersEntity withShippingAmount(String shippingAmount) {
		this.shippingAmount = shippingAmount;
		return this;
	}

	/**
	 * 
	 * @return The shippingTaxAmount
	 */
	public String getShippingTaxAmount() {
		return shippingTaxAmount;
	}

	/**
	 * 
	 * @param shippingTaxAmount
	 *            The shipping_tax_amount
	 */
	public void setShippingTaxAmount(String shippingTaxAmount) {
		this.shippingTaxAmount = shippingTaxAmount;
	}

	public OrdersEntity withShippingTaxAmount(String shippingTaxAmount) {
		this.shippingTaxAmount = shippingTaxAmount;
		return this;
	}

	/**
	 * 
	 * @return The storeToOrderRate
	 */
	public String getStoreToOrderRate() {
		return storeToOrderRate;
	}

	/**
	 * 
	 * @param storeToOrderRate
	 *            The store_to_order_rate
	 */
	public void setStoreToOrderRate(String storeToOrderRate) {
		this.storeToOrderRate = storeToOrderRate;
	}

	public OrdersEntity withStoreToOrderRate(String storeToOrderRate) {
		this.storeToOrderRate = storeToOrderRate;
		return this;
	}

	/**
	 * 
	 * @return The subtotal
	 */
	public String getSubtotal() {
		return subtotal;
	}

	/**
	 * 
	 * @param subtotal
	 *            The subtotal
	 */
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public OrdersEntity withSubtotal(String subtotal) {
		this.subtotal = subtotal;
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

	public OrdersEntity withTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
		return this;
	}

	/**
	 * 
	 * @return The totalPaid
	 */
	public Object getTotalPaid() {
		return totalPaid;
	}

	/**
	 * 
	 * @param totalPaid
	 *            The total_paid
	 */
	public void setTotalPaid(Object totalPaid) {
		this.totalPaid = totalPaid;
	}

	public OrdersEntity withTotalPaid(Object totalPaid) {
		this.totalPaid = totalPaid;
		return this;
	}

	/**
	 * 
	 * @return The totalRefunded
	 */
	public Object getTotalRefunded() {
		return totalRefunded;
	}

	/**
	 * 
	 * @param totalRefunded
	 *            The total_refunded
	 */
	public void setTotalRefunded(Object totalRefunded) {
		this.totalRefunded = totalRefunded;
	}

	public OrdersEntity withTotalRefunded(Object totalRefunded) {
		this.totalRefunded = totalRefunded;
		return this;
	}

	/**
	 * 
	 * @return The baseShippingDiscountAmount
	 */
	public String getBaseShippingDiscountAmount() {
		return baseShippingDiscountAmount;
	}

	/**
	 * 
	 * @param baseShippingDiscountAmount
	 *            The base_shipping_discount_amount
	 */
	public void setBaseShippingDiscountAmount(String baseShippingDiscountAmount) {
		this.baseShippingDiscountAmount = baseShippingDiscountAmount;
	}

	public OrdersEntity withBaseShippingDiscountAmount(String baseShippingDiscountAmount) {
		this.baseShippingDiscountAmount = baseShippingDiscountAmount;
		return this;
	}

	/**
	 * 
	 * @return The baseSubtotalInclTax
	 */
	public String getBaseSubtotalInclTax() {
		return baseSubtotalInclTax;
	}

	/**
	 * 
	 * @param baseSubtotalInclTax
	 *            The base_subtotal_incl_tax
	 */
	public void setBaseSubtotalInclTax(String baseSubtotalInclTax) {
		this.baseSubtotalInclTax = baseSubtotalInclTax;
	}

	public OrdersEntity withBaseSubtotalInclTax(String baseSubtotalInclTax) {
		this.baseSubtotalInclTax = baseSubtotalInclTax;
		return this;
	}

	/**
	 * 
	 * @return The baseTotalDue
	 */
	public Object getBaseTotalDue() {
		return baseTotalDue;
	}

	/**
	 * 
	 * @param baseTotalDue
	 *            The base_total_due
	 */
	public void setBaseTotalDue(Object baseTotalDue) {
		this.baseTotalDue = baseTotalDue;
	}

	public OrdersEntity withBaseTotalDue(Object baseTotalDue) {
		this.baseTotalDue = baseTotalDue;
		return this;
	}

	/**
	 * 
	 * @return The shippingDiscountAmount
	 */
	public String getShippingDiscountAmount() {
		return shippingDiscountAmount;
	}

	/**
	 * 
	 * @param shippingDiscountAmount
	 *            The shipping_discount_amount
	 */
	public void setShippingDiscountAmount(String shippingDiscountAmount) {
		this.shippingDiscountAmount = shippingDiscountAmount;
	}

	public OrdersEntity withShippingDiscountAmount(String shippingDiscountAmount) {
		this.shippingDiscountAmount = shippingDiscountAmount;
		return this;
	}

	/**
	 * 
	 * @return The subtotalInclTax
	 */
	public String getSubtotalInclTax() {
		return subtotalInclTax;
	}

	/**
	 * 
	 * @param subtotalInclTax
	 *            The subtotal_incl_tax
	 */
	public void setSubtotalInclTax(String subtotalInclTax) {
		this.subtotalInclTax = subtotalInclTax;
	}

	public OrdersEntity withSubtotalInclTax(String subtotalInclTax) {
		this.subtotalInclTax = subtotalInclTax;
		return this;
	}

	/**
	 * 
	 * @return The totalDue
	 */
	public Object getTotalDue() {
		return totalDue;
	}

	/**
	 * 
	 * @param totalDue
	 *            The total_due
	 */
	public void setTotalDue(Object totalDue) {
		this.totalDue = totalDue;
	}

	public OrdersEntity withTotalDue(Object totalDue) {
		this.totalDue = totalDue;
		return this;
	}

	/**
	 * 
	 * @return The incrementId
	 */
	public String getIncrementId() {
		return incrementId;
	}

	/**
	 * 
	 * @param incrementId
	 *            The increment_id
	 */
	public void setIncrementId(String incrementId) {
		this.incrementId = incrementId;
	}

	public OrdersEntity withIncrementId(String incrementId) {
		this.incrementId = incrementId;
		return this;
	}

	/**
	 * 
	 * @return The baseCurrencyCode
	 */
	public String getBaseCurrencyCode() {
		return baseCurrencyCode;
	}

	/**
	 * 
	 * @param baseCurrencyCode
	 *            The base_currency_code
	 */
	public void setBaseCurrencyCode(String baseCurrencyCode) {
		this.baseCurrencyCode = baseCurrencyCode;
	}

	public OrdersEntity withBaseCurrencyCode(String baseCurrencyCode) {
		this.baseCurrencyCode = baseCurrencyCode;
		return this;
	}

	/**
	 * 
	 * @return The discountDescription
	 */
	public Object getDiscountDescription() {
		return discountDescription;
	}

	/**
	 * 
	 * @param discountDescription
	 *            The discount_description
	 */
	public void setDiscountDescription(Object discountDescription) {
		this.discountDescription = discountDescription;
	}

	public OrdersEntity withDiscountDescription(Object discountDescription) {
		this.discountDescription = discountDescription;
		return this;
	}

	/**
	 * 
	 * @return The remoteIp
	 */
	public Object getRemoteIp() {
		return remoteIp;
	}

	/**
	 * 
	 * @param remoteIp
	 *            The remote_ip
	 */
	public void setRemoteIp(Object remoteIp) {
		this.remoteIp = remoteIp;
	}

	public OrdersEntity withRemoteIp(Object remoteIp) {
		this.remoteIp = remoteIp;
		return this;
	}

	/**
	 * 
	 * @return The storeCurrencyCode
	 */
	public String getStoreCurrencyCode() {
		return storeCurrencyCode;
	}

	/**
	 * 
	 * @param storeCurrencyCode
	 *            The store_currency_code
	 */
	public void setStoreCurrencyCode(String storeCurrencyCode) {
		this.storeCurrencyCode = storeCurrencyCode;
	}

	public OrdersEntity withStoreCurrencyCode(String storeCurrencyCode) {
		this.storeCurrencyCode = storeCurrencyCode;
		return this;
	}

	/**
	 * 
	 * @return The storeName
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * 
	 * @param storeName
	 *            The store_name
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public OrdersEntity withStoreName(String storeName) {
		this.storeName = storeName;
		return this;
	}

	/**
	 * 
	 * @return The createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * 
	 * @param createdAt
	 *            The created_at
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public OrdersEntity withCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * 
	 * @return The shippingInclTax
	 */
	public String getShippingInclTax() {
		return shippingInclTax;
	}

	/**
	 * 
	 * @param shippingInclTax
	 *            The shipping_incl_tax
	 */
	public void setShippingInclTax(String shippingInclTax) {
		this.shippingInclTax = shippingInclTax;
	}

	public OrdersEntity withShippingInclTax(String shippingInclTax) {
		this.shippingInclTax = shippingInclTax;
		return this;
	}

	/**
	 * 
	 * @return The baseCustomerBalanceAmount
	 */
	public Object getBaseCustomerBalanceAmount() {
		return baseCustomerBalanceAmount;
	}

	/**
	 * 
	 * @param baseCustomerBalanceAmount
	 *            The base_customer_balance_amount
	 */
	public void setBaseCustomerBalanceAmount(Object baseCustomerBalanceAmount) {
		this.baseCustomerBalanceAmount = baseCustomerBalanceAmount;
	}

	public OrdersEntity withBaseCustomerBalanceAmount(Object baseCustomerBalanceAmount) {
		this.baseCustomerBalanceAmount = baseCustomerBalanceAmount;
		return this;
	}

	/**
	 * 
	 * @return The customerBalanceAmount
	 */
	public Object getCustomerBalanceAmount() {
		return customerBalanceAmount;
	}

	/**
	 * 
	 * @param customerBalanceAmount
	 *            The customer_balance_amount
	 */
	public void setCustomerBalanceAmount(Object customerBalanceAmount) {
		this.customerBalanceAmount = customerBalanceAmount;
	}

	public OrdersEntity withCustomerBalanceAmount(Object customerBalanceAmount) {
		this.customerBalanceAmount = customerBalanceAmount;
		return this;
	}

	/**
	 * 
	 * @return The paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * 
	 * @param paymentMethod
	 *            The payment_method
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public OrdersEntity withPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		return this;
	}

	/**
	 * 
	 * @return The giftMessageFrom
	 */
	public String getGiftMessageFrom() {
		return giftMessageFrom;
	}

	/**
	 * 
	 * @param giftMessageFrom
	 *            The gift_message_from
	 */
	public void setGiftMessageFrom(String giftMessageFrom) {
		this.giftMessageFrom = giftMessageFrom;
	}

	public OrdersEntity withGiftMessageFrom(String giftMessageFrom) {
		this.giftMessageFrom = giftMessageFrom;
		return this;
	}

	/**
	 * 
	 * @return The giftMessageTo
	 */
	public String getGiftMessageTo() {
		return giftMessageTo;
	}

	/**
	 * 
	 * @param giftMessageTo
	 *            The gift_message_to
	 */
	public void setGiftMessageTo(String giftMessageTo) {
		this.giftMessageTo = giftMessageTo;
	}

	public OrdersEntity withGiftMessageTo(String giftMessageTo) {
		this.giftMessageTo = giftMessageTo;
		return this;
	}

	/**
	 * 
	 * @return The giftMessageBody
	 */
	public String getGiftMessageBody() {
		return giftMessageBody;
	}

	/**
	 * 
	 * @param giftMessageBody
	 *            The gift_message_body
	 */
	public void setGiftMessageBody(String giftMessageBody) {
		this.giftMessageBody = giftMessageBody;
	}

	public OrdersEntity withGiftMessageBody(String giftMessageBody) {
		this.giftMessageBody = giftMessageBody;
		return this;
	}

	/**
	 * 
	 * @return The taxName
	 */
	public Object getTaxName() {
		return taxName;
	}

	/**
	 * 
	 * @param taxName
	 *            The tax_name
	 */
	public void setTaxName(Object taxName) {
		this.taxName = taxName;
	}

	public OrdersEntity withTaxName(Object taxName) {
		this.taxName = taxName;
		return this;
	}

	/**
	 * 
	 * @return The taxRate
	 */
	public Object getTaxRate() {
		return taxRate;
	}

	/**
	 * 
	 * @param taxRate
	 *            The tax_rate
	 */
	public void setTaxRate(Object taxRate) {
		this.taxRate = taxRate;
	}

	public OrdersEntity withTaxRate(Object taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	/**
	 * 
	 * @return The addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * 
	 * @param addresses
	 *            The addresses
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public OrdersEntity withAddresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	/**
	 * 
	 * @return The orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * 
	 * @param orderItems
	 *            The order_items
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrdersEntity withOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
		return this;
	}

	/**
	 * 
	 * @return The orderComments
	 */
	public List<OrderComment> getOrderComments() {
		return orderComments;
	}

	/**
	 * 
	 * @param orderComments
	 *            The order_comments
	 */
	public void setOrderComments(List<OrderComment> orderComments) {
		this.orderComments = orderComments;
	}

	public OrdersEntity withOrderComments(List<OrderComment> orderComments) {
		this.orderComments = orderComments;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

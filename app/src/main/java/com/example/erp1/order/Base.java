package com.example.erp1.order;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Base {
    /**
     * resultCode : 200
     * data : {"markets":[{"id":1,"matchId":1,"developingTime":1,"developingCost":10,"name":"本地","score":5,"createTime":null,"createUserId":null,"developed":null},{"id":2,"matchId":1,"developingTime":1,"developingCost":10,"name":"区域","score":5,"createTime":null,"createUserId":null,"developed":null},{"id":3,"matchId":1,"developingTime":2,"developingCost":10,"name":"国内","score":10,"createTime":null,"createUserId":null,"developed":null},{"id":4,"matchId":1,"developingTime":3,"developingCost":10,"name":"亚洲","score":10,"createTime":null,"createUserId":null,"developed":null},{"id":5,"matchId":1,"developingTime":4,"developingCost":10,"name":"国际","score":10,"createTime":null,"createUserId":null,"developed":null}],"data":{"1":{"product":1,"orders":[{"id":192812,"orderNo":"8-0001","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192813,"orderNo":"8-0002","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192814,"orderNo":"8-0003","marketId":1,"productId":1,"amount":100,"deliveryPeriod":1,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192815,"orderNo":"8-0004","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192816,"orderNo":"8-0005","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192817,"orderNo":"8-0006","marketId":1,"productId":1,"amount":150,"deliveryPeriod":4,"iso":0,"num":3,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192818,"orderNo":"8-0007","marketId":1,"productId":1,"amount":200,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192819,"orderNo":"8-0008","marketId":1,"productId":1,"amount":190,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":1,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192820,"orderNo":"8-0009","marketId":1,"productId":1,"amount":290,"deliveryPeriod":4,"iso":0,"num":6,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}],"time":42,"user":3695,"users":[{"productId":0,"userId":3695,"matchId":1,"ad":5,"totalAd":7,"sale":0,"totalSale":0,"adTime":1590122839000,"chances":3,"abandon":false},{"productId":0,"userId":3696,"matchId":1,"ad":5,"totalAd":8,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":3,"abandon":false}],"status":1},"2":{"product":3,"orders":[{"id":192838,"orderNo":"8-0027","marketId":2,"productId":3,"amount":80,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192839,"orderNo":"8-0028","marketId":2,"productId":3,"amount":150,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192840,"orderNo":"8-0029","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192841,"orderNo":"8-0030","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}],"time":42,"user":3696,"users":[{"productId":0,"userId":3696,"matchId":1,"ad":4,"totalAd":11,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":2,"abandon":false}],"status":1}},"tip":"订单会开始","status":1}
     * resultMessage : 操作成功
     */

    private int resultCode;
    private DataBeanX data;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public static class DataBeanX {
        /**
         * markets : [{"id":1,"matchId":1,"developingTime":1,"developingCost":10,"name":"本地","score":5,"createTime":null,"createUserId":null,"developed":null},{"id":2,"matchId":1,"developingTime":1,"developingCost":10,"name":"区域","score":5,"createTime":null,"createUserId":null,"developed":null},{"id":3,"matchId":1,"developingTime":2,"developingCost":10,"name":"国内","score":10,"createTime":null,"createUserId":null,"developed":null},{"id":4,"matchId":1,"developingTime":3,"developingCost":10,"name":"亚洲","score":10,"createTime":null,"createUserId":null,"developed":null},{"id":5,"matchId":1,"developingTime":4,"developingCost":10,"name":"国际","score":10,"createTime":null,"createUserId":null,"developed":null}]
         * data : {"1":{"product":1,"orders":[{"id":192812,"orderNo":"8-0001","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192813,"orderNo":"8-0002","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192814,"orderNo":"8-0003","marketId":1,"productId":1,"amount":100,"deliveryPeriod":1,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192815,"orderNo":"8-0004","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192816,"orderNo":"8-0005","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192817,"orderNo":"8-0006","marketId":1,"productId":1,"amount":150,"deliveryPeriod":4,"iso":0,"num":3,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192818,"orderNo":"8-0007","marketId":1,"productId":1,"amount":200,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192819,"orderNo":"8-0008","marketId":1,"productId":1,"amount":190,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":1,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192820,"orderNo":"8-0009","marketId":1,"productId":1,"amount":290,"deliveryPeriod":4,"iso":0,"num":6,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}],"time":42,"user":3695,"users":[{"productId":0,"userId":3695,"matchId":1,"ad":5,"totalAd":7,"sale":0,"totalSale":0,"adTime":1590122839000,"chances":3,"abandon":false},{"productId":0,"userId":3696,"matchId":1,"ad":5,"totalAd":8,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":3,"abandon":false}],"status":1},"2":{"product":3,"orders":[{"id":192838,"orderNo":"8-0027","marketId":2,"productId":3,"amount":80,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192839,"orderNo":"8-0028","marketId":2,"productId":3,"amount":150,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192840,"orderNo":"8-0029","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192841,"orderNo":"8-0030","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}],"time":42,"user":3696,"users":[{"productId":0,"userId":3696,"matchId":1,"ad":4,"totalAd":11,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":2,"abandon":false}],"status":1}}
         * tip : 订单会开始
         * status : 1
         */

        private DataBean data;
        private String tip;
        private int status;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
        public static class DataBean {
            /**
             * 1 : {"product":1,"orders":[{"id":192812,"orderNo":"8-0001","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192813,"orderNo":"8-0002","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192814,"orderNo":"8-0003","marketId":1,"productId":1,"amount":100,"deliveryPeriod":1,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192815,"orderNo":"8-0004","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192816,"orderNo":"8-0005","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192817,"orderNo":"8-0006","marketId":1,"productId":1,"amount":150,"deliveryPeriod":4,"iso":0,"num":3,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192818,"orderNo":"8-0007","marketId":1,"productId":1,"amount":200,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192819,"orderNo":"8-0008","marketId":1,"productId":1,"amount":190,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":1,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192820,"orderNo":"8-0009","marketId":1,"productId":1,"amount":290,"deliveryPeriod":4,"iso":0,"num":6,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}],"time":42,"user":3695,"users":[{"productId":0,"userId":3695,"matchId":1,"ad":5,"totalAd":7,"sale":0,"totalSale":0,"adTime":1590122839000,"chances":3,"abandon":false},{"productId":0,"userId":3696,"matchId":1,"ad":5,"totalAd":8,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":3,"abandon":false}],"status":1}
             * 2 : {"product":3,"orders":[{"id":192838,"orderNo":"8-0027","marketId":2,"productId":3,"amount":80,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192839,"orderNo":"8-0028","marketId":2,"productId":3,"amount":150,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192840,"orderNo":"8-0029","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192841,"orderNo":"8-0030","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}],"time":42,"user":3696,"users":[{"productId":0,"userId":3696,"matchId":1,"ad":4,"totalAd":11,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":2,"abandon":false}],"status":1}
             */
//
//            @SerializedName("1")
//            private _$1Bean _$1;
//            @SerializedName("2")
//            private _$2Bean _$2;
//
//            public _$1Bean get_$1() {
//                return _$1;
//            }
//
//            public void set_$1(_$1Bean _$1) {
//                this._$1 = _$1;
//            }
//
//            public _$2Bean get_$2() {
//                return _$2;
//            }
//
//            public void set_$2(_$2Bean _$2) {
//                this._$2 = _$2;
//            }
                public market1Bean market1;
                public market2Bean market2;
                public market3Bean market3;
                public market4Bean market4;
                public market5Bean market5;

            public market1Bean getMarket1() {
                return market1;
            }

            public void setMarket1(market1Bean market1) {
                this.market1 = market1;
            }

            public market2Bean getMarket2() {
                return market2;
            }

            public void setMarket2(market2Bean market2) {
                this.market2 = market2;
            }

            public market3Bean getMarket3() {
                return market3;
            }

            public void setMarket3(market3Bean market3) {
                this.market3 = market3;
            }

            public market4Bean getMarket4() {
                return market4;
            }

            public void setMarket4(market4Bean market4) {
                this.market4 = market4;
            }

            public market5Bean getMarket5() {
                return market5;
            }

            public void setMarket5(market5Bean market5) {
                this.market5 = market5;
            }

            public static class _$1Bean {
                /**
                 * product : 1
                 * orders : [{"id":192812,"orderNo":"8-0001","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192813,"orderNo":"8-0002","marketId":1,"productId":1,"amount":50,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":0,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192814,"orderNo":"8-0003","marketId":1,"productId":1,"amount":100,"deliveryPeriod":1,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192815,"orderNo":"8-0004","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192816,"orderNo":"8-0005","marketId":1,"productId":1,"amount":100,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192817,"orderNo":"8-0006","marketId":1,"productId":1,"amount":150,"deliveryPeriod":4,"iso":0,"num":3,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192818,"orderNo":"8-0007","marketId":1,"productId":1,"amount":200,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192819,"orderNo":"8-0008","marketId":1,"productId":1,"amount":190,"deliveryPeriod":4,"iso":0,"num":4,"receivablePeriod":1,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192820,"orderNo":"8-0009","marketId":1,"productId":1,"amount":290,"deliveryPeriod":4,"iso":0,"num":6,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}]
                 * time : 42
                 * user : 3695
                 * users : [{"productId":0,"userId":3695,"matchId":1,"ad":5,"totalAd":7,"sale":0,"totalSale":0,"adTime":1590122839000,"chances":3,"abandon":false},{"productId":0,"userId":3696,"matchId":1,"ad":5,"totalAd":8,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":3,"abandon":false}]
                 * status : 1
                 */

                private int product;
                private int time;
                private int user;
                private int status;
                private List<OrdersBean> orders;
                private List<UsersBean> users;

                public int getProduct() {
                    return product;
                }

                public void setProduct(int product) {
                    this.product = product;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }

                public int getUser() {
                    return user;
                }

                public void setUser(int user) {
                    this.user = user;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public List<OrdersBean> getOrders() {
                    return orders;
                }

                public void setOrders(List<OrdersBean> orders) {
                    this.orders = orders;
                }

                public List<UsersBean> getUsers() {
                    return users;
                }

                public void setUsers(List<UsersBean> users) {
                    this.users = users;
                }

                public static class OrdersBean {
                    /**
                     * id : 192812
                     * orderNo : 8-0001
                     * marketId : 1
                     * productId : 1
                     * amount : 50
                     * deliveryPeriod : 4
                     * iso : 0
                     * num : 1
                     * receivablePeriod : 0
                     * year : 2
                     * type : 0
                     * matchId : 1
                     * createTime : null
                     * createUserId : null
                     */

                    private int id;
                    private String orderNo;
                    private int marketId;
                    private int productId;
                    private int amount;
                    private int deliveryPeriod;
                    private int iso;
                    private int num;
                    private int receivablePeriod;
                    private int year;
                    private int type;
                    private int matchId;
                    private Object createTime;
                    private Object createUserId;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getOrderNo() {
                        return orderNo;
                    }

                    public void setOrderNo(String orderNo) {
                        this.orderNo = orderNo;
                    }

                    public int getMarketId() {
                        return marketId;
                    }

                    public void setMarketId(int marketId) {
                        this.marketId = marketId;
                    }

                    public int getProductId() {
                        return productId;
                    }

                    public void setProductId(int productId) {
                        this.productId = productId;
                    }

                    public int getAmount() {
                        return amount;
                    }

                    public void setAmount(int amount) {
                        this.amount = amount;
                    }

                    public int getDeliveryPeriod() {
                        return deliveryPeriod;
                    }

                    public void setDeliveryPeriod(int deliveryPeriod) {
                        this.deliveryPeriod = deliveryPeriod;
                    }

                    public int getIso() {
                        return iso;
                    }

                    public void setIso(int iso) {
                        this.iso = iso;
                    }

                    public int getNum() {
                        return num;
                    }

                    public void setNum(int num) {
                        this.num = num;
                    }

                    public int getReceivablePeriod() {
                        return receivablePeriod;
                    }

                    public void setReceivablePeriod(int receivablePeriod) {
                        this.receivablePeriod = receivablePeriod;
                    }

                    public int getYear() {
                        return year;
                    }

                    public void setYear(int year) {
                        this.year = year;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int getMatchId() {
                        return matchId;
                    }

                    public void setMatchId(int matchId) {
                        this.matchId = matchId;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public Object getCreateUserId() {
                        return createUserId;
                    }

                    public void setCreateUserId(Object createUserId) {
                        this.createUserId = createUserId;
                    }
                }

                public static class UsersBean {
                    /**
                     * productId : 0
                     * userId : 3695
                     * matchId : 1
                     * ad : 5
                     * totalAd : 7
                     * sale : 0
                     * totalSale : 0
                     * adTime : 1590122839000
                     * chances : 3
                     * abandon : false
                     */

                    private int productId;
                    private int userId;
                    private int matchId;
                    private int ad;
                    private int totalAd;
                    private int sale;
                    private int totalSale;
                    private long adTime;
                    private int chances;
                    private boolean abandon;

                    public int getProductId() {
                        return productId;
                    }

                    public void setProductId(int productId) {
                        this.productId = productId;
                    }

                    public int getUserId() {
                        return userId;
                    }

                    public void setUserId(int userId) {
                        this.userId = userId;
                    }

                    public int getMatchId() {
                        return matchId;
                    }

                    public void setMatchId(int matchId) {
                        this.matchId = matchId;
                    }

                    public int getAd() {
                        return ad;
                    }

                    public void setAd(int ad) {
                        this.ad = ad;
                    }

                    public int getTotalAd() {
                        return totalAd;
                    }

                    public void setTotalAd(int totalAd) {
                        this.totalAd = totalAd;
                    }

                    public int getSale() {
                        return sale;
                    }

                    public void setSale(int sale) {
                        this.sale = sale;
                    }

                    public int getTotalSale() {
                        return totalSale;
                    }

                    public void setTotalSale(int totalSale) {
                        this.totalSale = totalSale;
                    }

                    public long getAdTime() {
                        return adTime;
                    }

                    public void setAdTime(long adTime) {
                        this.adTime = adTime;
                    }

                    public int getChances() {
                        return chances;
                    }

                    public void setChances(int chances) {
                        this.chances = chances;
                    }

                    public boolean isAbandon() {
                        return abandon;
                    }

                    public void setAbandon(boolean abandon) {
                        this.abandon = abandon;
                    }
                }
            }

            public static class _$2Bean {
                /**
                 * product : 3
                 * orders : [{"id":192838,"orderNo":"8-0027","marketId":2,"productId":3,"amount":80,"deliveryPeriod":4,"iso":0,"num":1,"receivablePeriod":3,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192839,"orderNo":"8-0028","marketId":2,"productId":3,"amount":150,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192840,"orderNo":"8-0029","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null},{"id":192841,"orderNo":"8-0030","marketId":2,"productId":3,"amount":160,"deliveryPeriod":4,"iso":0,"num":2,"receivablePeriod":2,"year":2,"type":0,"matchId":1,"createTime":null,"createUserId":null}]
                 * time : 42
                 * user : 3696
                 * users : [{"productId":0,"userId":3696,"matchId":1,"ad":4,"totalAd":11,"sale":0,"totalSale":0,"adTime":1590152253000,"chances":2,"abandon":false}]
                 * status : 1
                 */

                private int product;
                private int time;
                private int user;
                private int status;
                private List<OrdersBeanX> orders;
                private List<UsersBeanX> users;

                public int getProduct() {
                    return product;
                }

                public void setProduct(int product) {
                    this.product = product;
                }

                public int getTime() {
                    return time;
                }

                public void setTime(int time) {
                    this.time = time;
                }

                public int getUser() {
                    return user;
                }

                public void setUser(int user) {
                    this.user = user;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public List<OrdersBeanX> getOrders() {
                    return orders;
                }

                public void setOrders(List<OrdersBeanX> orders) {
                    this.orders = orders;
                }

                public List<UsersBeanX> getUsers() {
                    return users;
                }

                public void setUsers(List<UsersBeanX> users) {
                    this.users = users;
                }

                public static class OrdersBeanX {
                    /**
                     * id : 192838
                     * orderNo : 8-0027
                     * marketId : 2
                     * productId : 3
                     * amount : 80
                     * deliveryPeriod : 4
                     * iso : 0
                     * num : 1
                     * receivablePeriod : 3
                     * year : 2
                     * type : 0
                     * matchId : 1
                     * createTime : null
                     * createUserId : null
                     */

                    private int id;
                    private String orderNo;
                    private int marketId;
                    private int productId;
                    private int amount;
                    private int deliveryPeriod;
                    private int iso;
                    private int num;
                    private int receivablePeriod;
                    private int year;
                    private int type;
                    private int matchId;
                    private Object createTime;
                    private Object createUserId;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getOrderNo() {
                        return orderNo;
                    }

                    public void setOrderNo(String orderNo) {
                        this.orderNo = orderNo;
                    }

                    public int getMarketId() {
                        return marketId;
                    }

                    public void setMarketId(int marketId) {
                        this.marketId = marketId;
                    }

                    public int getProductId() {
                        return productId;
                    }

                    public void setProductId(int productId) {
                        this.productId = productId;
                    }

                    public int getAmount() {
                        return amount;
                    }

                    public void setAmount(int amount) {
                        this.amount = amount;
                    }

                    public int getDeliveryPeriod() {
                        return deliveryPeriod;
                    }

                    public void setDeliveryPeriod(int deliveryPeriod) {
                        this.deliveryPeriod = deliveryPeriod;
                    }

                    public int getIso() {
                        return iso;
                    }

                    public void setIso(int iso) {
                        this.iso = iso;
                    }

                    public int getNum() {
                        return num;
                    }

                    public void setNum(int num) {
                        this.num = num;
                    }

                    public int getReceivablePeriod() {
                        return receivablePeriod;
                    }

                    public void setReceivablePeriod(int receivablePeriod) {
                        this.receivablePeriod = receivablePeriod;
                    }

                    public int getYear() {
                        return year;
                    }

                    public void setYear(int year) {
                        this.year = year;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int getMatchId() {
                        return matchId;
                    }

                    public void setMatchId(int matchId) {
                        this.matchId = matchId;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public Object getCreateUserId() {
                        return createUserId;
                    }

                    public void setCreateUserId(Object createUserId) {
                        this.createUserId = createUserId;
                    }
                }

                public static class UsersBeanX {
                    /**
                     * productId : 0
                     * userId : 3696
                     * matchId : 1
                     * ad : 4
                     * totalAd : 11
                     * sale : 0
                     * totalSale : 0
                     * adTime : 1590152253000
                     * chances : 2
                     * abandon : false
                     */

                    private int productId;
                    private int userId;
                    private int matchId;
                    private int ad;
                    private int totalAd;
                    private int sale;
                    private int totalSale;
                    private long adTime;
                    private int chances;
                    private boolean abandon;

                    public int getProductId() {
                        return productId;
                    }

                    public void setProductId(int productId) {
                        this.productId = productId;
                    }

                    public int getUserId() {
                        return userId;
                    }

                    public void setUserId(int userId) {
                        this.userId = userId;
                    }

                    public int getMatchId() {
                        return matchId;
                    }

                    public void setMatchId(int matchId) {
                        this.matchId = matchId;
                    }

                    public int getAd() {
                        return ad;
                    }

                    public void setAd(int ad) {
                        this.ad = ad;
                    }

                    public int getTotalAd() {
                        return totalAd;
                    }

                    public void setTotalAd(int totalAd) {
                        this.totalAd = totalAd;
                    }

                    public int getSale() {
                        return sale;
                    }

                    public void setSale(int sale) {
                        this.sale = sale;
                    }

                    public int getTotalSale() {
                        return totalSale;
                    }

                    public void setTotalSale(int totalSale) {
                        this.totalSale = totalSale;
                    }

                    public long getAdTime() {
                        return adTime;
                    }

                    public void setAdTime(long adTime) {
                        this.adTime = adTime;
                    }

                    public int getChances() {
                        return chances;
                    }

                    public void setChances(int chances) {
                        this.chances = chances;
                    }

                    public boolean isAbandon() {
                        return abandon;
                    }

                    public void setAbandon(boolean abandon) {
                        this.abandon = abandon;
                    }
                }
            }
        }

        public static class MarketsBean {
            /**
             * id : 1
             * matchId : 1
             * developingTime : 1
             * developingCost : 10
             * name : 本地
             * score : 5
             * createTime : null
             * createUserId : null
             * developed : null
             */

            private int id;
            private int matchId;
            private int developingTime;
            private int developingCost;
            private String name;
            private int score;
            private Object createTime;
            private Object createUserId;
            private Object developed;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMatchId() {
                return matchId;
            }

            public void setMatchId(int matchId) {
                this.matchId = matchId;
            }

            public int getDevelopingTime() {
                return developingTime;
            }

            public void setDevelopingTime(int developingTime) {
                this.developingTime = developingTime;
            }

            public int getDevelopingCost() {
                return developingCost;
            }

            public void setDevelopingCost(int developingCost) {
                this.developingCost = developingCost;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(Object createUserId) {
                this.createUserId = createUserId;
            }

            public Object getDeveloped() {
                return developed;
            }

            public void setDeveloped(Object developed) {
                this.developed = developed;
            }
        }
    }
}


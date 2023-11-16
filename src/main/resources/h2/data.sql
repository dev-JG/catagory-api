insert into category(category_no, category_name) values (10, '상의');
insert into category(category_no, category_name) values (12, '아우터');
insert into category(category_no, category_name) values (14, '바지');
insert into category(category_no, category_name) values (16, '스니커즈');
insert into category(category_no, category_name) values (18, '가방');
insert into category(category_no, category_name) values (20, '모자');
insert into category(category_no, category_name) values (22, '양말');
insert into category(category_no, category_name) values (24, '액세서리');

insert into brand(brand_no, brand_name) values (100, 'A');
insert into brand(brand_no, brand_name) values (110, 'B');
insert into brand(brand_no, brand_name) values (120, 'C');
insert into brand(brand_no, brand_name) values (130, 'D');
insert into brand(brand_no, brand_name) values (140, 'E');
insert into brand(brand_no, brand_name) values (150, 'F');
insert into brand(brand_no, brand_name) values (160, 'G');
insert into brand(brand_no, brand_name) values (170, 'H');
insert into brand(brand_no, brand_name) values (180, 'I');

-- 브랜드 A 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 10, '상의A', 11200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 12, '아우터A', 5500, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 14, '바지A', 4200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 16, '스니커즈A', 9000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 18, '가방A', 2000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 20, '모자A', 1700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 22, '양말A', 1800, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (100, 24, '액세서리A', 2300, 'SALE');
-- 브랜드 B 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 10, '상의B', 10500, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 12, '아우터B', 5900, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 14, '바지B', 3800, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 16, '스니커즈B', 9100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 18, '가방B', 2100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 20, '모자B', 2000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 22, '양말B', 2000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (110, 24, '액세서리B', 2200, 'SALE');
-- 브랜드 C 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 10, '상의C', 10000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 12, '아우터C', 6200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 14, '바지C', 3300, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 16, '스니커즈C', 9200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 18, '가방C', 2200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 20, '모자C', 1900, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 22, '양말C', 2200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (120, 24, '액세서리C', 2100, 'SALE');
-- 브랜드 D 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 10, '상의D', 10100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 12, '아우터D', 5100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 14, '바지D', 3000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 16, '스니커즈D', 9500, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 18, '가방D', 2500, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 20, '모자D', 1500, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 22, '양말D', 2400, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (130, 24, '액세서리D', 2000, 'SALE');
-- 브랜드 E 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 10, '상의E', 10700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 12, '아우터E', 5000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 14, '바지E', 3800, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 16, '스니커즈E', 9900, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 18, '가방E', 2300, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 20, '모자E', 1800, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 22, '양말E', 2100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (140, 24, '액세서리E', 2100, 'SALE');
-- 브랜드 F 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 10, '상의F', 11200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 12, '아우터F', 7200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 14, '바지F', 4000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 16, '스니커즈F', 9300, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 18, '가방F', 2100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 20, '모자F', 1600, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 22, '양말F', 2300, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (150, 24, '액세서리F', 1900, 'SALE');
-- 브랜드 G 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 10, '상의G', 10500, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 12, '아우터G', 5800, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 14, '바지G', 3900, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 16, '스니커즈G', 9000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 18, '가방G', 2200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 20, '모자G', 1700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 22, '양말G', 2100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (160, 24, '액세서리G', 2000, 'SALE');
-- 브랜드 H 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 10, '상의H', 10800, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 12, '아우터H', 6300, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 14, '바지H', 3100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 16, '스니커즈H', 9700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 18, '가방H', 2100, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 20, '모자H', 1600, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 22, '양말H', 2000, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (170, 24, '액세서리H', 2000, 'SALE');
-- 브랜드 I 데이터
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 10, '상의I', 11400, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 12, '아우터I', 6700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 14, '바지I', 3200, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 16, '스니커즈I', 9600, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 18, '가방I', 2400, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 20, '모자I', 1700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 22, '양말I', 1700, 'SALE');
insert into goods(brand_no, category_no, goods_name, price, status) values (180, 24, '액세서리I', 2400, 'SALE');

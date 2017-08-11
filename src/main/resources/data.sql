INSERT INTO USER (FIRST_name, last_name, nickname, email, password, average_rating, review_number_counter)
VALUES ('alkin', 'sen', 'sena', 'alkin.sen@monitise.com', 'Passw0rd', 0, 0);
INSERT INTO USER (FIRST_name, last_name, nickname, email, password, average_rating, review_number_counter)
VALUES ('enis', 'simsar', 'simsare', 'enis.simssar@monitise.com', 'Passw0rd', 0, 0);
INSERT INTO USER (FIRST_name, last_name, nickname, email, PASSWORD, average_rating, review_number_counter)
VALUES ('yalin', 'popstar', 'yapops', 'yalin.pops@muzique.com', '123456', 0, 0);
INSERT INTO USER (FIRST_name, last_name, nickname, email, PASSWORD, average_rating, review_number_counter)
VALUES ('burak', 'yilmaz', 'byilmaz', 'burak.yilmaz@monitise.com', 'cimbom', 0, 0);
INSERT INTO USER (FIRST_name, last_name, nickname, email, PASSWORD, average_rating, review_number_counter)
VALUES ('serdar', 'ortac', 'sortac', 'serdar.ortac@monitise.com', 'giybet', 0, 0);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active, price)
VALUES (2, '2. Sinema bileti bedava', 'cinemaximumda geçerli', TRUE, TRUE, 0, 0, TRUE, 10);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active, price)
VALUES (3, 'istinye park alışveriş', 'istinye parkta 100tl lik alışverişe 20tl indirim var', TRUE, TRUE, 0, 0, TRUE, 10);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active, price)
VALUES (4, 'nike 200tl hediye kartı', 'sadece eski sezon ayakkabılarda geçerli', TRUE, TRUE, 0, 0, TRUE, 190);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active, price)
VALUES (2, 'vodafone red şifrelerim', 'vodafone kampanyalarında kullanılabilecek şifrelerimi satıyorum', TRUE, TRUE, 0, 0, TRUE, 5);
INSERT INTO REFERENCE (comment, rating, writer_nickname, user_id, date_of_creation)
VALUES ('Hiç bir sıkıntı yaratmadı, çok temiz bir alış-veriş oldu.', 3, 'sena', 2, CURRENT_TIMESTAMP);
INSERT INTO REFERENCE (comment, rating, writer_nickname, user_id, date_of_creation)
VALUES ('Biraz geç geldi alış-verişe ama hızla hallettik.', 2, 'android_head', 2, CURRENT_TIMESTAMP);
INSERT INTO REFERENCE (comment, rating, writer_nickname, user_id, date_of_creation)
VALUES ('iyi düzgün ahlaklı', 5, 'ailerle', 2, CURRENT_TIMESTAMP);
INSERT INTO user_interest (user_id, interest_set) VALUES (2, 'CLOTHING');
INSERT INTO user_interest (user_id, interest_set) VALUES (1, 'ELECTRONICS');
INSERT INTO user_interest (user_id, interest_set) VALUES (1, 'FOOD');
INSERT INTO user_interest (user_id, interest_set) VALUES (2, 'FOOD');
INSERT INTO user_interest (user_id, interest_set) VALUES (3, 'FOOD');
INSERT INTO user_interest (user_id, interest_set) VALUES (4, 'FOOD');
INSERT INTO user_interest (user_id, interest_set) VALUES (5, 'FOOD');
INSERT INTO user_interest (user_id, interest_set) VALUES (1, 'FOOD');
insert into deal (locationx,locationy,user_id, title, description, cold_vote_counter, hot_vote_counter, comment_count)
values (0,0,1, 'nusrette %20', 'ZUBIZU indir %20ye varan indirim yakala', 0, 0, 0);
insert into deal (locationx,locationy,user_id, title, description, cold_vote_counter, hot_vote_counter, comment_count)
values (0,0,2, 'istinye parkta pazar indirimi', 'kıyafet alışverişlerinde genel %10 indirim var kaçırmayın', 0, 0, 0);
insert into deal (locationx,locationy,user_id, title, description, cold_vote_counter, hot_vote_counter, comment_count)
values (0,0,2, 'ets tatil rezervasyonu', 'tatil rezervasyonunu etsden yaparsan sana parfüm veriyorlar 20 tane aldım!!!!', 0, 0, 0);
insert into deal (locationx,locationy,user_id, title, description, cold_vote_counter, hot_vote_counter, comment_count)
values (0,0,5, 'd-smart fiber internet', '150GB 59Tl çok iyi bir fiyat performansa sahip', 0, 0, 0);
INSERT INTO deal_categories (deal_id, categories) VALUES (1, 'FOOD');
INSERT INTO deal_categories (deal_id, categories) VALUES (2, 'FOOD');
INSERT INTO deal_categories (deal_id, categories) VALUES (3, 'COSMETICS');
INSERT INTO deal_categories (deal_id, categories) VALUES (4, 'ELECTRONICS');
INSERT INTO comment (body, date_of_creation, deal_id, writer_nickname)
VALUES ('bana %5 çıktı, arkadaşa %20 şanssızım', CURRENT_TIMESTAMP, 1, 'simsare');



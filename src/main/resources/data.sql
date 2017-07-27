INSERT INTO USER (FIRST_name, last_name, nick_name, email, password)
VALUES ('alkin', 'sen', 'sena', 'alkin.sen@monitise.com', 'Passw0rd');
INSERT INTO USER (FIRST_name, last_name, nick_name, email, PASSWORD)
VALUES ('yalin', 'popstar', 'yapops', 'yalin.pops@muzique.com', '123456');
INSERT INTO USER (FIRST_name, last_name, nick_name, email, PASSWORD)
VALUES ('enis', 'simsar', 'simsare', 'enis.simsar@monitise.com', '12345');
INSERT INTO USER (FIRST_name, last_name, nick_name, email, PASSWORD)
VALUES ('burak', 'yilmaz', 'byilmaz', 'burak.yilmaz@monitise.com', 'cimbom');
INSERT INTO USER (FIRST_name, last_name, nick_name, email, PASSWORD)
VALUES ('serdar', 'ortac', 'sortac', 'serdar.ortac@monitise.com', 'giybet');

INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active)
VALUES (2, 'beles konser', 'harika bir firsat', TRUE, TRUE, 0, 0, TRUE);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active)
VALUES (3, 'beles koltuk', 'belese otur', TRUE, TRUE, 0, 0, TRUE);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active)
VALUES (4, 'ucuz ayakkabı', 'yuru bee', TRUE, TRUE, 0, 0, TRUE);
INSERT INTO COUPON (user_id, title, description, accepts_cash_payment, accepts_online_payment, cold_vote_counter, hot_vote_counter, is_active)
VALUES (2, 'maliyetine kullanılmış çamaşır', 'az kullanılmış', TRUE, TRUE, 0, 0, TRUE);

INSERT INTO DEAL (user_id, title, description, cold_vote_counter, hot_vote_counter)
VALUES (1, 'nusrette %20', 'at etinden geçerli sadece', 0, 0);
INSERT INTO DEAL (user_id, title, description, cold_vote_counter, hot_vote_counter)
VALUES (2, 'nusrette %50', 'sadece suda geçerli', 0, 0);
INSERT INTO DEAL (user_id, title, description, cold_vote_counter, hot_vote_counter)
VALUES (4, 'nusrette +%10', 'bu dealla %10 fazla ödeyip bahşiş bırakmasanda olur', 0, 0);
INSERT INTO DEAL (user_id, title, description, cold_vote_counter, hot_vote_counter)
VALUES (5, 'nusret -%0', 'normal parayı veriyon', 0, 0);




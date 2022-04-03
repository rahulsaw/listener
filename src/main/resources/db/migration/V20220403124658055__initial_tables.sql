CREATE TABLE `account_transaction`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `account_number`      int(11) NOT NULL,
    `account_from` int(11) NOT NULL,
    `amount`       int (11) NOT NULL,
    `currency`     varchar(11) NOT NULL,
    `type`         varchar(11) NOT NULL,
    `created_at`     datetime DEFAULT CURRENT_TIMESTAMP,
    `updated_at`     datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ;

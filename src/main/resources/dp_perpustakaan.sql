/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : dp_perpustakaan

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 28/11/2019 09:14:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buku
-- ----------------------------
DROP TABLE IF EXISTS `buku`;
CREATE TABLE `buku`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `judul` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `id_kategori` bigint(20) NOT NULL,
  `id_penerbit` bigint(20) NOT NULL,
  `isbn` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `pengarang` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `halaman` int(4) NOT NULL,
  `thn_terbit` date NOT NULL,
  `image` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sinopsis` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `barcode` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKe3bukfcctopvp6aduagbg46tg`(`id_kategori`) USING BTREE,
  INDEX `FKs3phtyy0nk5g7ep5ab8lixdxv`(`id_penerbit`) USING BTREE,
  CONSTRAINT `FKe3bukfcctopvp6aduagbg46tg` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs3phtyy0nk5g7ep5ab8lixdxv` FOREIGN KEY (`id_penerbit`) REFERENCES `publiser` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buku
-- ----------------------------
INSERT INTO `buku` VALUES (4, 'ddddddd', 3, 2, '99999999999999', 'Budi Santoso', 122, '2019-11-14', 'images.jpg', 'inin sinopsis', '919218829112');
INSERT INTO `buku` VALUES (6, 'ddddddd', 3, 2, '99999999999999', 'Budi Santoso', 122, '2019-11-14', 'images.jpg', 'inin sinopsis', '919218829112');
INSERT INTO `buku` VALUES (7, 'ddddddd', 3, 2, '99999999999999', 'Budi Santoso', 122, '2019-11-14', 'images.jpg', 'inin sinopsis', '919218829112');

-- ----------------------------
-- Table structure for kategori
-- ----------------------------
DROP TABLE IF EXISTS `kategori`;
CREATE TABLE `kategori`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kategori
-- ----------------------------
INSERT INTO `kategori` VALUES (2, 'Sejarah');
INSERT INTO `kategori` VALUES (3, 'Politik');
INSERT INTO `kategori` VALUES (4, 'Sejarah');
INSERT INTO `kategori` VALUES (5, 'Novel');
INSERT INTO `kategori` VALUES (6, 'Novel');
INSERT INTO `kategori` VALUES (8, 'Sejarah');
INSERT INTO `kategori` VALUES (9, 'Sejarah');
INSERT INTO `kategori` VALUES (10, 'q');

-- ----------------------------
-- Table structure for pengadaan
-- ----------------------------
DROP TABLE IF EXISTS `pengadaan`;
CREATE TABLE `pengadaan`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tgl_pengadaan` datetime(0) NOT NULL,
  `id_buku` bigint(20) NOT NULL,
  `asal_buku` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `jumlah` int(3) NOT NULL,
  `keterangan` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pengadaan
-- ----------------------------
INSERT INTO `pengadaan` VALUES (1, '2019-11-18 07:00:00', 3, 'adddds', 122, 'asss');
INSERT INTO `pengadaan` VALUES (5, '2019-11-18 07:00:00', 2, 'as', 12, 'as');
INSERT INTO `pengadaan` VALUES (6, '2019-11-18 07:00:00', 2, 'as', 12, 'as');

-- ----------------------------
-- Table structure for pengembalian
-- ----------------------------
DROP TABLE IF EXISTS `pengembalian`;
CREATE TABLE `pengembalian`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_pinjam` bigint(20) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` int(12) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pengembalian
-- ----------------------------
INSERT INTO `pengembalian` VALUES (1, 1, '2019-11-19', 0, 6);

-- ----------------------------
-- Table structure for pinjaman
-- ----------------------------
DROP TABLE IF EXISTS `pinjaman`;
CREATE TABLE `pinjaman`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tgl_pinjam` date NOT NULL,
  `id_siswa` bigint(20) NOT NULL,
  `keterangan` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `lama_pinjam` int(3) NOT NULL,
  `status` enum('1','0') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '0',
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pinjaman
-- ----------------------------
INSERT INTO `pinjaman` VALUES (1, '2019-11-18', 5, 'asd', 12, '1', 6);

-- ----------------------------
-- Table structure for pinjaman_item
-- ----------------------------
DROP TABLE IF EXISTS `pinjaman_item`;
CREATE TABLE `pinjaman_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_pinjam` bigint(255) NOT NULL,
  `id_buku` bigint(20) NOT NULL,
  `jumlah` int(2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pinjaman_item
-- ----------------------------
INSERT INTO `pinjaman_item` VALUES (1, 1, 4, 1);

-- ----------------------------
-- Table structure for publiser
-- ----------------------------
DROP TABLE IF EXISTS `publiser`;
CREATE TABLE `publiser`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publiser
-- ----------------------------
INSERT INTO `publiser` VALUES (1, 'Jogo');
INSERT INTO `publiser` VALUES (2, 'Novel');
INSERT INTO `publiser` VALUES (3, 'Novel');
INSERT INTO `publiser` VALUES (4, 'Novel');

-- ----------------------------
-- Table structure for siswa
-- ----------------------------
DROP TABLE IF EXISTS `siswa`;
CREATE TABLE `siswa`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nisn` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `gender` enum('Laki-laki','Perempuan') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `religion` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `tempat_lahir` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `address` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `telp` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `image` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of siswa
-- ----------------------------
INSERT INTO `siswa` VALUES (5, 'Novendius Eka Saputra', '123912661', 'Laki-laki', 'Islam', 'Sukoharo', '1997-11-02', 'Brangkulon RT 02/09 Kedungsono, Bulu, Sukoharjo', '087231611', 'image.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(150) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'asdasda12312', 'a1212sd1', 'asd1212dw');
INSERT INTO `user` VALUES (7, 'asdasda12312', '1111', 'wwwwwwwwww');
INSERT INTO `user` VALUES (8, 'asdasda12312', '1111', 'wwwwwwwwww');
INSERT INTO `user` VALUES (9, 'vendi', 'vendi', '$2a$10$4JyFTe/CwlDVDD15ffOJmO.tTfURFbiH0Lh.Q.f1VZDZpv/mICG5a');
INSERT INTO `user` VALUES (10, 'vendi', 'vend12i', 'asd1212dw');
INSERT INTO `user` VALUES (11, 'vendi', 'popo', 'asd1212dw');
INSERT INTO `user` VALUES (12, 'vendi', 'admin', '$2a$10$AzQ3SlFY7msaOfh208Zt0ufap3KfQDA7FxPtjxt3IhywGXRvTMhaG');

SET FOREIGN_KEY_CHECKS = 1;

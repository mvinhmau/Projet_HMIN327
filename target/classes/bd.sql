drop table AssocieA;
drop table Monument;
drop table Lieu;
drop table Celebrite;
drop table Departement;



create table Departement
(
    numDep varchar(4) primary key,
	nomDep varchar(46)
);
create table Lieu
    (
        codeInsee varchar(5)  primary key, 
        dep varchar(4), 
        nomCom varchar(46), 
        longitude float, 
        latitude float,
        foreign key (dep) references Departement(numDep)
    );

create table Monument
    (
        codeM integer primary key, 
        nomM varchar(25), 
        proprietaire varchar(10), 
        typeMonument varchar(16), longitude float, 
        latitude float, codeLieu varchar(5), 
        foreign key (codeLieu) references Lieu(codeInsee)
    );

create table Celebrite 
    (
        numCelebrite integer  primary key, 
        nom varchar(16), 
        prenom varchar(16), 
        nationalite varchar(48), 
        epoque varchar(48)
    );

create table AssocieA 
    (
        numCelebrite integer, 
        codeM varchar(5), 
        primary key (numCelebrite, codeM), 
        foreign key (numCelebrite) references Celebrite(numCelebrite), 
        foreign key (codeM) references Monument(codeM)
    );


-- Insertion Table Departement
INSERT INTO Departement  VALUES
('01', 'Ain'),
('02', 'Aisne'),
('03', 'Allier'),
('05', 'Hautes-Alpes'),
('04', 'Alpes-de-Haute-Provence'),
('06', 'Alpes-Maritimes'),
('07', 'Ardèche'),
('08', 'Ardennes'),
('09', 'Ariège'),
('10', 'Aube'),
('11', 'Aude'),
('12', 'Aveyron'),
('13', 'Bouches-du-Rhône'),
('14', 'Calvados'),
('15', 'Cantal'),
('16', 'Charente'),
('17', 'Charente-Maritime'),
('18', 'Cher'),
('19', 'Corrèze'),
('2a', 'Corse-du-sud'),
('2b', 'Haute-corse'),
('21', 'Côte-d''or'),
('22', 'Côtes-d''armor'),
('23', 'Creuse'),
('24', 'Dordogne'),
('25', 'Doubs'),
('26', 'Drôme'),
('27', 'Eure'),
('28', 'Eure-et-Loir'),
('29', 'Finistère'),
('30', 'Gard'),
('31', 'Haute-Garonne'),
('32', 'Gers'),
('33', 'Gironde'),
('34', 'Hérault'),
('35', 'Ile-et-Vilaine'),
('36', 'Indre'),
('37', 'Indre-et-Loire'),
('38', 'Isère'),
('39', 'Jura'),
('40', 'Landes'),
('41', 'Loir-et-Cher'),
('42', 'Loire'),
('43', 'Haute-Loire'),
('44', 'Loire-Atlantique'),
('45', 'Loiret'),
('46', 'Lot'),
('47', 'Lot-et-Garonne'),
('48', 'Lozère'),
('49', 'Maine-et-Loire'),
('50', 'Manche'),
('51', 'Marne'),
('52', 'Haute-Marne'),
('53', 'Mayenne'),
('54', 'Meurthe-et-Moselle'),
('55', 'Meuse'),
('56', 'Morbihan'),
('57', 'Moselle'),
('58', 'Nièvre'),
('59', 'Nord'),
('60', 'Oise'),
('61', 'Orne'),
('62', 'Pas-de-Calais'),
('63', 'Puy-de-Dôme'),
('64', 'Pyrénées-Atlantiques'),
('65', 'Hautes-Pyrénées'),
('66', 'Pyrénées-Orientales'),
('67', 'Bas-Rhin'),
('68', 'Haut-Rhin'),
('69', 'Rhône'),
('70', 'Haute-Saône'),
('71', 'Saône-et-Loire'),
('72', 'Sarthe'),
('73', 'Savoie'),
('74', 'Haute-Savoie'),
('75', 'Paris'),
('76', 'Seine-Maritime'),
('77', 'Seine-et-Marne'),
('78', 'Yvelines'),
('79', 'Deux-Sèvres'),
('80', 'Somme'),
('81', 'Tarn'),
('82', 'Tarn-et-Garonne'),
('83', 'Var'),
('84', 'Vaucluse'),
('85', 'Vendée'),
('86', 'Vienne'),
('87', 'Haute-Vienne'),
('88', 'Vosges'),
('89', 'Yonne'),
('90', 'Territoire de Belfort'),
('91', 'Essonne'),
('92', 'Hauts-de-Seine'),
('93', 'Seine-Saint-Denis'),
('94', 'Val-de-Marne'),
('95', 'Val-d''oise'),
('976', 'Mayotte'),
('971', 'Guadeloupe'),
('973', 'Guyane'),
('972', 'Martinique'),
('974', 'Réunion');

-- Insertion  Lieu  

insert into Lieu values 
('34172','34','Montpellier',3.876,43.6108),
('34192','34','Palavas-les-Flots',3.933,43.533),
('34199','34','Pezenas',3.416,43.45);




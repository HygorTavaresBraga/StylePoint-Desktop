-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Jan-2022 às 05:47
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `stylepoint`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nomeCliente` varchar(15) NOT NULL,
  `enderecoCliente` varchar(100) NOT NULL,
  `telefoneCliente` varchar(14) NOT NULL,
  `cpfCliente` varchar(14) NOT NULL,
  `emailCliente` varchar(30) NOT NULL,
  `dataNascimentoCliente` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nomeCliente`, `enderecoCliente`, `telefoneCliente`, `cpfCliente`, `emailCliente`, `dataNascimentoCliente`) VALUES
(3, 'Dalúncio', 'Rua dos Prazeres, Nº 69', '(21)95554-8554', '222.222.222-22', 'daluncio@orkut.net', '04-12-1998'),
(5, 'Djalma', 'Rua A, Nº 69', '(21)96635-8487', '075.663.159-87', 'djalminhacria@msn.com', '09-04-1992');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `idRoupa` int(11) NOT NULL,
  `nomeRoupa` varchar(15) NOT NULL,
  `descricao` varchar(20) NOT NULL,
  `preco` double NOT NULL,
  `tamanho` varchar(5) NOT NULL,
  `cor` varchar(15) NOT NULL,
  `idFornecedor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`idRoupa`, `nomeRoupa`, `descricao`, `preco`, `tamanho`, `cor`, `idFornecedor`) VALUES
(6, 'Casaco Adidas', 'Pele de Rato', 50, 'G', 'Marrom', NULL),
(8, 'Sapato', 'Couro de Jacaré', 200, '36', 'Rosa', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `idFornecedor` int(11) NOT NULL,
  `razaoSocial` varchar(50) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `enderecoFornecedor` varchar(50) NOT NULL,
  `telefoneFornecedor` varchar(14) NOT NULL,
  `emailFornecedor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`idFornecedor`, `razaoSocial`, `cnpj`, `enderecoFornecedor`, `telefoneFornecedor`, `emailFornecedor`) VALUES
(1, 'COCA-COLA LTDA', '111.111.111-11', 'Rua Dia Betes, Nº 69', '(21)94474-4444', 'contato@cocacola.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `idFuncionario` int(11) NOT NULL,
  `nomeFuncionario` varchar(100) NOT NULL,
  `dataNascimentoFuncionario` varchar(10) NOT NULL,
  `dataAdmissao` varchar(10) NOT NULL,
  `cpfFuncionario` varchar(14) NOT NULL,
  `enderecoFuncionario` varchar(50) NOT NULL,
  `telefoneFuncionario` varchar(14) NOT NULL,
  `emailFuncionario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens`
--

CREATE TABLE `itens` (
  `idItem` int(11) NOT NULL,
  `preco` double NOT NULL,
  `quantidade` varchar(3) NOT NULL,
  `idRoupa` int(11) NOT NULL,
  `idLocacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacoes`
--

CREATE TABLE `locacoes` (
  `idLocacao` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `idRoupa` int(11) DEFAULT NULL,
  `dataLocacao` varchar(10) NOT NULL,
  `dataDevolucao` varchar(10) NOT NULL,
  `observacao` varchar(100) NOT NULL,
  `valorTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `locacoes`
--

INSERT INTO `locacoes` (`idLocacao`, `idCliente`, `idFuncionario`, `idRoupa`, `dataLocacao`, `dataDevolucao`, `observacao`, `valorTotal`) VALUES
(5, 3, NULL, 6, '25-01-2022', '10-02-2022', 'Nenhuma', 50);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(25) NOT NULL,
  `loginUsuario` varchar(50) NOT NULL,
  `senhaUsuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nomeUsuario`, `loginUsuario`, `senhaUsuario`) VALUES
(2, 'admin', 'admin', '123'),
(4, 'teste', 'teste', '123');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `telefone` (`telefoneCliente`),
  ADD UNIQUE KEY `cpf` (`cpfCliente`),
  ADD UNIQUE KEY `email` (`emailCliente`);

--
-- Índices para tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idRoupa`),
  ADD UNIQUE KEY `nomeRoupa` (`nomeRoupa`),
  ADD KEY `idFornecedor` (`idFornecedor`);

--
-- Índices para tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`idFornecedor`),
  ADD UNIQUE KEY `cnpj` (`cnpj`),
  ADD UNIQUE KEY `telefone` (`telefoneFornecedor`),
  ADD UNIQUE KEY `email` (`emailFornecedor`);

--
-- Índices para tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`idFuncionario`),
  ADD UNIQUE KEY `cpf` (`cpfFuncionario`),
  ADD UNIQUE KEY `telefone` (`telefoneFuncionario`),
  ADD UNIQUE KEY `email` (`emailFuncionario`);

--
-- Índices para tabela `itens`
--
ALTER TABLE `itens`
  ADD PRIMARY KEY (`idItem`),
  ADD KEY `idLocacao` (`idLocacao`),
  ADD KEY `idRoupa` (`idRoupa`);

--
-- Índices para tabela `locacoes`
--
ALTER TABLE `locacoes`
  ADD PRIMARY KEY (`idLocacao`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idRoupa` (`idRoupa`),
  ADD KEY `idFuncionario` (`idFuncionario`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `email` (`loginUsuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idRoupa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `idFornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `itens`
--
ALTER TABLE `itens`
  MODIFY `idItem` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `locacoes`
--
ALTER TABLE `locacoes`
  MODIFY `idLocacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedores` (`idFornecedor`);

--
-- Limitadores para a tabela `itens`
--
ALTER TABLE `itens`
  ADD CONSTRAINT `itens_ibfk_1` FOREIGN KEY (`idLocacao`) REFERENCES `locacoes` (`idLocacao`),
  ADD CONSTRAINT `itens_ibfk_2` FOREIGN KEY (`idRoupa`) REFERENCES `estoque` (`idRoupa`);

--
-- Limitadores para a tabela `locacoes`
--
ALTER TABLE `locacoes`
  ADD CONSTRAINT `locacoes_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  ADD CONSTRAINT `locacoes_ibfk_2` FOREIGN KEY (`idRoupa`) REFERENCES `estoque` (`idRoupa`),
  ADD CONSTRAINT `locacoes_ibfk_3` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`idFuncionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

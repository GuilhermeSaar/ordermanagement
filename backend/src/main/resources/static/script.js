
const apiUrl = 'http://localhost:8080';

// Funcao para buscar os clientes
async function fetchClients() {
    try {

        const response = await fetch(`${apiUrl}/clients`);
        const data = await response.json();

        // acesse a lista de clients dentro de 'content'
        const clients = data.content;

        // verifique se os clients foram encontrados
        if (clients.length === 0) {
            console.log('Nenhum cliente encontrado')
        }

        const clientList = document.getElementById('client-list');
        clientList.innerHTML = clients.map(client => `
            <div>
                <h3>${client.name}</h3>
                <p>ID: ${client.id}</p>
                <p>Email: ${client.email}</p>
                <p>Data Nascimento: ${client.birthDate}</p>
            </div>
        `).join('');
    } catch (error) {
        console.error('Erro ao buscar clientes:', error);
    }
}


// funcao para buscar produtos
async function fetchProducts() {
    try {
        const response = await fetch(`${apiUrl}/products`);
        const data = await response.json(); // A resposta agora é um objeto com o campo 'content'

        // Acesse a lista de produtos dentro de 'content'
        const products = data.content;

        // Verifique se os produtos foram encontrados
        if (products.length === 0) {
            console.log('Nenhum produto encontrado');
        }

        const productList = document.getElementById('product-list');
        productList.innerHTML = products.map(product => `
            <div>
                <h3>${product.name}</h3>
                <p>ID: ${product.id}</p>
                <p>Descrição: ${product.description}</p>
                <p>Preço: ${product.price}</p>
                <p>Estoque: ${product.quantityStock}</p>
            </div>
        `).join('');
    } catch (error) {
        console.error('Erro ao buscar produtos:', error);
    }
}


// Função para buscar os pedidos
async function fetchOrders() {
    try {
        const response = await fetch(`${apiUrl}/orders`);
        const orders = await response.json();
        const orderList = document.getElementById('order-list');
        orderList.innerHTML = orders.map(order => `
            <div>
                <h3>Pedido ID: ${order.id}</h3>
                <p>Cliente: ${order.client.name}</p>
                <p>Total: ${order.total}</p>
                <p>Status: ${order.status}</p>
            </div>
        `).join('');
    } catch (error) {
        console.error('Erro ao buscar pedidos:', error);
    }
}




<template>
  <div class="products">
    <h1>
      Produtos
    </h1>

    <b-card class="mt-2 mb-2">
      <router-link :to="{ name: 'product' }">
        <b-btn variant="success" id="add" class="mr-2">Adicionar</b-btn>
      </router-link>
    </b-card>

    <b-card class="mt-4 mb-2">
      <h5 class="mb-3">
        Lista produtos
      </h5>
      <table class="table table-hover table-dark">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Descrição</th>
          <th scope="col">Tipo do produto</th>
          <th scope="col">Valor no Fornecedor</th>
          <th scope="col">Quantidade em estoque</th>
          <th class="text-center" scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" :key="product.id">
          <th scope="row">{{product.id}}</th>
          <td>{{product.description}}</td>
          <td>{{getProductTypeLabel(product.productType)}}</td>
          <td>R$ {{product.supplierPrice}}</td>
          <td>{{product.amount}}</td>
          <td class="text-center">
            <div role="button" @click="editProduct(product.id)" class="ml-2 d-inline-block"><font-awesome-icon icon="pencil-alt"/></div>
            <div role="button" @click="deleteProduct(product.id)" class="ml-2 d-inline-block"><font-awesome-icon icon="trash"/></div>
          </td>
        </tr>
      </tbody>
    </table>
    </b-card>
  </div>
</template>

<script>
  import api from "@/api/backend-api";

  export default {
    name: 'products',
    data() {
      return {
        products: []
      }
    },
    methods: {
      loadProducts() {
        api.getAllProducts().then(response => {
          this.products = response.data;
        });
      },
      deleteProduct(id) {
        if(confirm('Tem certeza que gostaria de deletar o produto?')){
          api.deleteProduct(id).then(() => {
            this.loadProducts();
            this.$toast.open('Produto excluido com sucesso!');
          });
        }
      },
      editProduct(id) {
        this.$router.push({ name: 'product', params: { id } });
      },
      getProductTypeLabel(value) {
        const productTypeEnum = {
          E: 'Eletrônico',
          D: 'Eletrodoméstico',
          M: 'Movel'
        };
        return productTypeEnum[value];
      }
    },
    mounted(){
      this.loadProducts();
    }
  }
</script>
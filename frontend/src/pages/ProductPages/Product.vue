<template>
  <div class="product">
    <h1>
      {{getTitleLabel()}}
    </h1>

    <b-card class="mt-4 mb-2">
      <div class="row m-2">
        <div class="col-md-6">
          <label for="input-live">Descrição:</label>
          <b-form-input
            id="input-live"
            v-model="product.description"
            placeholder="Descrição"
            trim
          ></b-form-input>
        </div>
        <div class="col-md-6">
          <label for="input-live">Tipo do produto:</label>
          <b-form-select v-model="product.productType" :options="options"></b-form-select>
        </div>
      </div>
      <div class="row m-2">
        <div class="col-md-6">
          <label for="input-live">Valor no fornecedor:</label>
          <b-form-input
            id="input-live"
            v-model="product.supplierPrice"
            type="number"
            placeholder="Valor fornecedor"
            trim
          ></b-form-input>
        </div>
        <div class="col-md-6">
          <label for="input-live">Quantidade estoque:</label>
          <b-form-input
            id="input-live"
            v-model="product.amount"
            min="1"
            type="number"
            placeholder="Quantidade estoque"
            trim
          ></b-form-input>
        </div>
      </div>
    </b-card>
    <b-card class="mt-2 mb-2">
      <b-btn variant="success" id="add" class="ml-2" @click="saveProduct()">Salvar</b-btn>
      <router-link :to="{ name: 'products' }">
        <b-btn id="edit" class="ml-2">Voltar</b-btn>
      </router-link>
    </b-card>
  </div>
</template>

<script>
  import api from "@/api/backend-api";

  export default {
    name: 'product',
    data() {
      return {
        product: {
          description: '',
          productType: null,
          supplierPrice: 0,
          amount: 1
        },
        options: [
          { value: null, text: 'Selecione um tipo de produto', disabled: true },
          { value: 'E', text: 'Eletrônico' },
          { value: 'D', text: 'Eletrodoméstico' },
          { value: 'M', text: 'Movel' },
        ]
      }
    },
    methods: {
      getTitleLabel() {
        return this.$route.params.id ? 'Editar produto': 'Adicionar produto';
      },
      saveProduct() {
        const id = this.$route.params.id;
        if (id) {
          api.editProduct(id, this.$data.product).then(() => {
            this.$router.push({ name: 'products' });
            this.$toast.open('Produto editado com sucesso!');
          });
        } else {
          api.addProduct(this.$data.product).then(() => {
            this.$router.push({ name: 'products' });
            this.$toast.open('Produto salvo com sucesso!');
          });
        }
      }
    },
    mounted() {
      const id = this.$route.params.id;
      if (id) {
        api.getProduct(id).then(result => {
          this.$data.product = result.data;
        });
      }
    }
  }

</script>
